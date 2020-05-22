// pre Java 5.0 code
synchronized(map) { // the lock has to be held for the whole loop.
    for(Iterator iter = map.entrySet().iterator(); iter.hashNext(); ) {
         Map.Entry entry = iter.next();
         String key = (String) entry.getKey();
         MyType value = (MyType) entry.getValue();
         // do something with key and value.
    }
}