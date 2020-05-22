public static void addURLToSystemClassLoader(URL url) throws IntrospectionException {
    URLClassLoader systemClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    Class<URLClassLoader> classLoaderClass = URLClassLoader.class;

    try {
        Method method = classLoaderClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(systemClassLoader, new Object[]{url});
    } catch (Throwable t) {
        t.printStackTrace();
        throw new IntrospectionException("Error when adding url to system ClassLoader ");
    }
}