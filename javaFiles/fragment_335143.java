// Assuming that Foo implements Comparable<Foo>
List<Foo> fooList = ...;
Foo maximum = Collections.max(fooList);
// Normally Foos are compared by the size of their baz, but now we want to
// find the Foo with the largest gimblefleck.
Foo maxGimble = Collections.max(fooList, new Comparator<Foo>() {
    @Override
    public int compare(Foo first, Foo second) {
        if (first.getGimblefleck() > second.getGimblefleck())
            return 1;
        else if (first.getGimblefleck() < second.getGimblefleck())
            return -1;
        return 0;
    }
});