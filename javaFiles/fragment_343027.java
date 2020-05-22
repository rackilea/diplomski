String methodNames[] = new String[]{"First", "Last", "Email"};
String className = "com.foo.Bar";
try {

    Class classRef = Class.forName(className);
    Object instance = classRef.newInstance();

    for (String methodName : methodNames) {

        try {

            Method method = classRef.getDeclaredMethod("validate" + methodName);
            method.invoke(instance);

        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

    }

} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
    ex.printStackTrace();
}