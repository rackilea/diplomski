ReactiveSeq.fromStream(Stream.of(1,2))
             .filter(this::include)
             .elapsed()
             .map(this::logAndUnwrap)

  Long[] filterTimeTakenMillis = new Long[maxSize];
  int filterIndex = 0;
  private <T> T logAndUnwrap(Tuple2<T, Long> t) {
      //capture the elapsed time (t.v2) and then unwrap the tuple
      filterTimeTakenMillis[filterIndex++]=t.v2;
      return t.v1;
  }