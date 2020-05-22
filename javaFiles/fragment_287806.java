@Test
public void howToCleanThreadLocalValues() throws ReflectiveOperationException {
    Thread thread = Thread.currentThread();

    // Set thread local value for current thread
    WeakReference<ThreadLocal> threadLocal = new WeakReference<>(new ThreadLocal<>());
    threadLocal.get().set("foo");

    // Get ThreadLocalMap
    Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
    threadLocalsField.setAccessible(true);
    WeakReference<Object> threadLocalMap = new WeakReference<>(threadLocalsField.get(thread));
    Assert.assertNotNull(threadLocalMap.get());
    Assert.assertNotNull(threadLocal.get());

    // Set ThreadLocalMap to null, GC do the rest
    threadLocalsField.set(Thread.currentThread(), null);
    System.gc();
    Assert.assertNull(threadLocalMap.get());
    Assert.assertNull(threadLocal.get());
}