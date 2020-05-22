public T cas(final String key, final T initial, int initialExp,
        final CASMutation<T> m) throws Exception {
    T rv=initial;

    boolean done=false;
    for(int i=0; !done && i<max; i++) {
        CASValue<T> casval=client.gets(key, transcoder);
        T current=null;
        // If there were a CAS value, check to see if it's compatible.
        if(casval != null) {
            T tmp = casval.getValue();
            current=tmp;
        }
        // If we have anything mutate and CAS, else add.
        if(current != null) {
            // Declaring this impossible since the only way current can
            // be non-null is if casval was set.
            assert casval != null : "casval was null with a current value";

            rv=m.getNewValue(current);
            // There are three possibilities here:
            //  1) It worked and we're done.
            //  2) It collided and we need to reload and try again.
            //  3) It disappeared between our fetch and our cas.
            // We're ignoring #3 because it's *extremely* unlikely and the
            // behavior will be fine in this code -- we'll do another gets
            // and follow it up with either an add or another cas depending
            // on whether it exists the next time.
            if(client.cas(key, casval.getCas(), rv, transcoder)
                    == CASResponse.OK) {
                done=true;
            }
        } else {
            // No value found, try an add.
            if(initial == null) {
                done = true;
                rv = null;
            } else if(client.add(key, initialExp, initial, transcoder).get()) {
                done=true;
                rv=initial;
            }
        }
    }
    if(!done) {
        throw new RuntimeException("Couldn't get a CAS in " + max
            + " attempts");
    }

    return rv;
}