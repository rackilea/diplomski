public static <T> Set<? extends T> forName(String modulePath, Set<String> classes, Class<T> claz) throws InvalidModuleException{
    try {
    ClassLoader cl = new URLClassLoader(new URL[]{new URL(modulePath)});

    Set<T> list = new HashSet<>(classes.size());
    for (String className : classes) {
        Class<?> clazz = Class.forName(className, true, cl);
        Constructor<?> ctor = clazz.getConstructor();
        Object obj = ctor.newInstance();
        list.add(claz.cast(obj));
    }
    return list;
} catch (MalformedURLException | ReflectiveOperationException | ClassCastException ex) {
    throw new InvalidModuleException(ex.getMessage());
}
}