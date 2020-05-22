protected <T extends IParam> void foo(SortedSet<T> params) {
    System.out.println("Doing something with sorted set);
}

protected <T extends IParam> void foo(Collection<T> params) {
    SortedSet<T> sortedParams = new TreeSet<T>(params);
    System.out.println("Doing something with other collection types");
    foo(sortedParams);
}