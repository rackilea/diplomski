public static Object coalesce(Object root, String... methods) {
    if (root == null) {
        return null;
    }
    for (String methodName : methods) {
        Class<?> klazz = root.getClass();
        try {
            Method method = klazz.getMethod(methodName);
            Object result = method.invoke(root);
            root = result;
            if (root == null) {
                break;
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            // Definitely make a nice informative error message.
        }
    }
    return root;
}