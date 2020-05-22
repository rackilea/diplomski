public static boolean isJreClass(Class<?> clazz) {
    ClassLoader cl = clazz.getClassLoader();
    if (cl == null || cl.getParent() == null) {
        return true;
    }
    String pkg = clazz.getPackage().getName();
    return pkg.startsWith("java.") || pkg.startsWith("com.sun") || pkg.startsWith("sun."); 
}