private ClassLoader findClassLoaderForContext(Class<?> c) {
  ClassLoader context = Thread.currentThread().getContextClassLoader();
  ClassLoader me = c.getClassLoader();
  ClassLoader system = ClassLoader.getSystemClassLoader();
  return (context == null) ? (me == null) ? system : me : context;
}