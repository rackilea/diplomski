@Test
  public void test() throws JSONException {
    JSONAssert.assertEquals("{x: 1, time:123}",
                            "{x: 1, time:234}",
                            new CustomComparator(
                              JSONCompareMode.STRICT,
                              Customization.customization("time", // json path you want to customize
                                                          new ValueMatcher() {
                                @Override public boolean equal(Object o1, Object o2) {
                                  return true; // in your case just ignore the values and return true
                                }
                              }))
    );
  }