/**
 * Returns the classloader used by this serializer.
 * @since JavaFX 2.1
 */
@CallerSensitive
public ClassLoader getClassLoader() {
    if (classLoader == null) {
        final SecurityManager sm = System.getSecurityManager();
        final Class caller = (sm != null) ?
                Reflection.getCallerClass() :
                null;
        return getDefaultClassLoader(caller);
    }
    return classLoader;
}

private static ClassLoader getDefaultClassLoader(Class caller) {
    if (defaultClassLoader == null) {
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            final ClassLoader callerClassLoader = (caller != null) ?
                    caller.getClassLoader() :
                    null;
            if (needsClassLoaderPermissionCheck(callerClassLoader, FXMLLoader.class.getClassLoader())) {
                sm.checkPermission(GET_CLASSLOADER_PERMISSION);
            }
        }
        return Thread.currentThread().getContextClassLoader();
    }
    return defaultClassLoader;
}