@Test
  void name() throws Exception {
    List<Integer> items = Arrays.asList(1, 2, 3, 4, 5);
    Flowable.fromIterable(items)
        .skipWhile(integer -> integer != 3)
        .take(2)
        .test()
        .assertValues(3, 4);
  }