Car car = Mockito.mock(Car.class, new Answer<Object>() {
  @Override public Object answer(InvocationOnMock invocation) {
    if (invocation.getMethod().getName().equals("isVeryBig")) {
      return false;
    }
    // Delegate to the default answer.
    return Mockito.RETURNS_DEFAULTS.answer(invocation);
  }
};