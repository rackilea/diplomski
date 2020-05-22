Parser parser = ParserFactory.getParser();
if (parser == null) {
  // now what?
  // this would be an example of where null isn't (or shouldn't be) a valid response
}
Action action = parser.findAction(someInput);
if (action == null) {
  // do nothing
} else {
  action.doSomething();
}