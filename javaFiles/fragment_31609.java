private static final Object DEFAULT_VALUE = new String("It works!");
  private static final Object OTHER_VALUE = new String("It's broken!");

  private Object foo(String input) {
    Object output = DEFAULT_VALUE;
    if(input != null && !"".equals(input.trim())) {
      output = OTHER_VALUE;
    }
    return output;
  }

  @SuppressWarnings("unused")
  private Object[] parameters() {
    return $(
          new Object[] { null },
          new Object[] { "" },
          new Object[] { " " }
          // ,"Other value"
        );
  }

  @Test
  @Parameters(method = "parameters")
  public void testing(String input) {
    Object obj = foo(input);
    assertEquals(obj, DEFAULT_VALUE);
  }