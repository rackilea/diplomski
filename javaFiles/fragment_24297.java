Class<?> unknownInterface = ClassLoader.getSystemClassLoader().loadClass("bar.UnknownInterface");

Object proxy = Proxy.newProxyInstance(unknownInterface.getClassLoader(),
                                      new Class[] { unknownInterface },
                                      new Handler());

unknownInterface.getMethod("someMethod", String.class).invoke(proxy, "hello");
// other way to call it:
// ((UnknownInterface) proxy).someMethod("hello");