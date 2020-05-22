public void PutIn(N n, V v) {
    Keeper kep = new Keeper(n,v);
    // you will insert between previous and current
    Keeper previous = null;
    Keeper current = første;

    // loop until you get the right place        
    while (current != null && ((current.n).compareTo(n) > 0)) {
        previous = current;
        current = current.neste;
    }

    // insert your stuff there (if there were no previous, then this is the first one)
    if (previous == null) {
        første = kep;
    } else {
        previous.neste = kep;
    }

    // Set the next Keeper
    kep.neste = current;

    ant++;
}