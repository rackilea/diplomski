try {
  doSomething();  // throws SomeException
  doSomethingElse();  // throws SomeOtherException
}
catch (SomeException e) {
  throw new PatternFormatException(..., e);
}
catch (SomeOtherException e2) {
  throw new PatternFormatException(..., e2);
}
catch (Exception e3) {
  throw new UnexpectedPatternFormatException(..., e3);
}