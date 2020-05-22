class Defaults implements InvocationHandler {
  public static <A extends Annotation> A of(Class<A> annotation) {
    return (A) Proxy.newProxyInstance(annotation.getClassLoader(),
        new Class[] {annotation}, new Defaults());
  }
  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
    return method.getDefaultValue();
  }
}

Settings s = Defaults.of(Settings.class);
System.out.printf("%s\n%s\n%s\n", s.a(), s.b(), s.c());