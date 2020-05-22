/** Instance field, package-private to replace in tests. */
Function<String, Handler> instanceCreator =
    ( x -> (Handler) Class.forName(x).newInstance());

public ReturnType yourMethodUnderTest(String className) {
  Handler handler = instanceCreator.apply(className);
  // ...
}