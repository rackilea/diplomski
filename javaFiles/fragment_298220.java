public void findInterestingFoo(Stream<Foo> foos) {
    Spliterator<Foo> sp = foos.spliterator();
    long size = sp.getExactSizeIfKnown();// returns -1 if not known
          // or sp.estimateSize(); // Long.MAX_VALUE means "unknown"
    internalState.update(
        StreamSupport.stream(sp, size > PARALLEL_THRESHOLD)
                     .collect(customCollector()));
}