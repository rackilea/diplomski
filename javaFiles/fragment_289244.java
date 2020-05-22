doReturn(true).when(object).method(
  argThat(new ArgumentMatcher<YourObject>() {
    @Override public boolean matches(Object argument) {
      if (!(argument instanceof YourObject)) {
        return false;
      }
      YourObject yourObject = (YourObject) argument;
      return "myProp1".equals(yourObject.getProp1())
          && "myProp2".equals(yourObject.getProp2());
    }
  })
)