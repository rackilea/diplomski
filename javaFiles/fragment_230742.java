public void GetCake(SuperClass someObject) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    Class clazz = someObject.getClass();
    Method method = clazz.getDeclaredMethod("TheCake");
    method.setAccessible(true);
    method.invoke(someObject);
}