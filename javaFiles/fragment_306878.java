@CallerSensitive
public static Class<?> forName(String className)
            throws ClassNotFoundException {
    return forName0(className, true,
                    ClassLoader.getClassLoader(Reflection.getCallerClass()));
}