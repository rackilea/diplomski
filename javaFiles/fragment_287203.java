public static <X> Multimap<Class<X>, X> splitByClass(
    final Iterable<? extends X> implementations, final Class<X> interfaceType) {

    final Multimap<Class<X>, X> mmap = HashMultimap.create();
    for (final X implementation : implementations) {
        @SuppressWarnings("unchecked")
        // this should be safe:
        final Class<X> implementationType = (Class<X>) implementation.getClass();
        mmap.put(implementationType, implementation);
    }
    return mmap;
}