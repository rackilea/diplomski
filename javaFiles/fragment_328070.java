public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    User user = new User();
    String name = runMethod(user, "getFirstName");
    System.out.println(name);
}

private static String runMethod(Object instance, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method method = instance.getClass().getMethod(methodName);
    return (String)method.invoke(instance);
}