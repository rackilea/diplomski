private static final AtomicLong TS_COUNTER = new AtomicLong();

 public static long nextTimeStamp() {
      long time = System.currentTimeMillis() * 1000;
      long curr = TS_COUNTER.get();
      if (curr < time && TS_COUNTER.compareAndSet(curr, time))
          return time;
      return TS_COUNTER.incrementAndGet();
 }