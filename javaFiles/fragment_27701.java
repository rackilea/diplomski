void someMethod(String constantName) throws NoSuchFieldException, IllegalAccessException {
    Field fd = Constants.class.getDeclaredField(constantName);
    fd.setAccessible(true);
    String val = (String) fd.get(null);
    callSomeOtherMethod(val);
}