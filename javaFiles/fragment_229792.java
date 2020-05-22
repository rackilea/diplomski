public class Test {

    public String method(String string, int integer) {
        return String.format("%s %d", string, integer);
    }

    public static void main(String[] args) throws Exception {

        ProxyFactory f = new ProxyFactory();
        f.setSuperclass(Test.class);

        Class<?> c = f.createClass();
        MethodHandler mi = new MethodHandler() {
            public Object invoke(
                    Object self, Method m, Method proceed, Object[] args)
                throws Throwable {

                System.out.printf("Method %s called with %s%n", 
                                  m.getName(), Arrays.toString(args));

                // call the original method
                return proceed.invoke(self, args);
            }
        };

        Test foo = (Test) c.newInstance();
        ((Proxy) foo).setHandler(mi);
        foo.method("Hello", 4711);
    }
}