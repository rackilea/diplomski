Function<Foo,Bar> f = foo -> {
  try {
    return foo.methodThatCanThrow();
  } catch (RuntimeException e) {
    throw e;
  } catch (Exception e) {
    throw new RuntimeException(e);
  }
};