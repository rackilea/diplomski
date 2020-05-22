public static Set<Method> findOverridingMethods(Object o) {
    Set<Method> overridingMethods = new HashSet<Method>();
    Class<?> clazz = o.getClass();
    for (Method method : clazz.getDeclaredMethods()) {
        Class<?> current = clazz.getSuperclass();
        while (current != null) {
            try {
                current.getDeclaredMethod(method.getName(), method.getParameterTypes());
                overridingMethods.add(method);
            } catch (NoSuchMethodException ignore) {
            }
            current = current.getSuperclass();
        }
    }
    return overridingMethods;
}