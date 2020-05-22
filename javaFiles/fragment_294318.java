BundleWiring bundleWiring = context.getBundle().adapt(BundleWiring.class);
ClassLoader bundleClassLoader = bundleWiring.getClassLoader();
Thread currentThread = Thread.currentThread();

ClassLoader originalCl = currentThread.getContextClassLoader()
currentThread.setContectClassLoader(bundleClassLoader);
try {
    System.err.println("Shiro : " + ClassUtils.forName("com.firm.demo.MyCustomClass"));
} finally {
    currentThread.setContextClassLoader(originalCl);
}