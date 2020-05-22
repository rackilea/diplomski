Class<?> clazz = plugin.getClass();
while (clazz != null) {
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
        // Test any other things about it beyond the name...
        if (method.getName().equals("getFile") && ...) {
            return method;
        }
    }
    clazz = clazz.getSuperclass();
}