String className = "java.lang.Integer";
ClassLoader loader = Thread.currentThread().getContextClassLoader();
Class<?> cls = loader.loadClass(className);
if(cls.isInstance(object)) {
    // ...
}