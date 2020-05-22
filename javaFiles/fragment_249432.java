try {
  doSomething();  // throws SomeException
  doSomethingElse();  // throws SomeOtherException
}
catch (Exception e) {
  throw new PatternFormatException(..., e);
}