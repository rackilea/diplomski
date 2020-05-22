ClassLoader oldContextClassLoader = Thread.currentThread().getContextClassLoader();
try {
    Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
    // TODO Add your code that uses JAX-WS
} finally {
    Thread.currentThread().setContextClassLoader(oldContextClassLoader);
}