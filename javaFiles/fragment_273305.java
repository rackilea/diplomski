Thread thread = Thread.currentThread();
ClassLoader old = thread.getContextClassLoader();
thread.setContextClassLoader(fooClassLoader);
try {
  // do call that depends on context ClassLoader
} finally {
  thread.setContextClassLoader(old);
}