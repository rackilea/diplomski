private List<Class<?>> findClass(BundleContext context, String name) {
    List<Class<?>> result = new ArrayList<Class<?>>();
    for (Bundle b : context.getBundles()) {
        try {
            Class<?> c = b.loadClass(name);
            result.add(c);
        } catch (ClassNotFoundException e) {
            // No problem, this bundle doesn't have the class
        }
    }
    return result;
}