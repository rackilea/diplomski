public ReturnType yourMethodUnderTest(String className) {
  return yourMethodUnderTest(Class.newInstance(className));
}

/** Package private for testing. */
public ReturnType yourMethodUnderTest(Handler handler) {
  return yourMethodUnderTest(Class.newInstance(className));
}