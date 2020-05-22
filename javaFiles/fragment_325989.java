protected <T extends IParam> void foo(Collection<T> params) {
    SortedSet<T> sortedParams;
    if (params instanceof SortedSet)
        sortedParams = (SortedSet<T>) params;
    else
        sortedParams = new TreeSet<T>(params);

    System.out.println(sortedParams);
}