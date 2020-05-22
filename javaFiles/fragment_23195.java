// Install a proxy class loader for adding renamed persistence.xml file
Thread t = Thread.currentThread();
ClassLoader clOriginal = t.getContextClassLoader();
t.setContextClassLoader(new SpecialClassLoader(clOriginal, "META-INF/my-persistence.xml"));

// Build EntityManagerFactory
EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);

// Restore original class loader
t.setContextClassLoader(clOriginal);

//...

private class ProxyClassLoader extends ClassLoader {
    private ClassLoader realClassLoader;
    private String hiddenFromJBossPersistenceFile;

    public ProxyClassLoader(ClassLoader realClassLoader, String hiddenFromJBossPersistenceFile) {
        this.realClassLoader = realClassLoader;
        this.hiddenFromJBossPersistenceFile = hiddenFromJBossPersistenceFile;
    }

    public void clearAssertionStatus() {
        realClassLoader.clearAssertionStatus();
    }

    public boolean equals(Object obj) {
        return realClassLoader.equals(obj);
    }

    public URL getResource(String name) {
        return realClassLoader.getResource(name);
    }

    public InputStream getResourceAsStream(String name) {
        return realClassLoader.getResourceAsStream(name);
    }

    public Enumeration<URL> getResources(String name) throws IOException {
        ArrayList<URL> resources = new ArrayList<URL>();

        if (name.equalsIgnoreCase("META-INF/persistence.xml")) {
            resources.add(getResource(this.hiddenFromJBossPersistenceFile));
        }
        resources.addAll(Collections.list(realClassLoader.getResources(name)));

        return Collections.enumeration(resources);
    }

    public int hashCode() {
        return realClassLoader.hashCode();
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return realClassLoader.loadClass(name);
    }

    public void setClassAssertionStatus(String className, boolean enabled) {
        realClassLoader.setClassAssertionStatus(className, enabled);
    }

    public void setDefaultAssertionStatus(boolean enabled) {
        realClassLoader.setDefaultAssertionStatus(enabled);
    }

    public void setPackageAssertionStatus(String packageName, boolean enabled) {
        realClassLoader.setPackageAssertionStatus(packageName, enabled);
    }

    public String toString() {
        return realClassLoader.toString();
    }
}