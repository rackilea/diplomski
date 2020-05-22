public void testFinished(Description description) throws Exception {
    Class<?> testClass = description.getTestClass();
    Method m = testClass.getDeclaredMethod("getDescription");
    Object o = m.invoke(null);
    System.out.println(o.toString());   
  }