class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader (URL[] urls) throws NoSuchMethodException {
        super(urls);
    }

    @Override
    protected Class<?> loadClass (String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> aClass = findClass(name);
            if (resolve) {
                resolveClass(aClass);
            }
            return aClass;
        }
    }
}