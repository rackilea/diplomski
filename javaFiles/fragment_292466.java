static Matcher<MyType> typeIdIs(final String id) {
  return new ArgumentMatcher<MyType>() {
    @Override
    public boolean matches(Object argument) {
      return id.equals(((MyType)argument).getID());
    }
  };
}

Mockito.verify(serviceMock, times(1)).serviceMethod(eq("someConstantValue"), argThat(typeIdIs("123")));