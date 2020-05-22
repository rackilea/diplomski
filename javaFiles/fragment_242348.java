public void run() {
    long seed = new Random().nextLong();
    long limit = (long) ((1L<<48) * threshold);

    for(int i=0; i<count; i++) {
      seed = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
      if (seed < limit) ++result;
    }
  }