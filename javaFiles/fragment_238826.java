static void test()
    {
      List<String> test = Arrays.asList("foo", "bar", "baz", "foobar", "barbaz");
      List<String[]> split = splitListIntoArrays(test, 2, String.class);
      split.forEach(s -> java.lang.System.out.println(Arrays.toString(s)));


      List<Long> test2 = Arrays.asList(1L,2L,3L,4L,5L);
      List<Long[]> split2 = splitListIntoArrays(test2, 2, Long.class);
      split2.forEach(s -> java.lang.System.out.println(Arrays.toString(s)));
    }