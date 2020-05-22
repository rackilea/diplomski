public class Main {
    public static String test(int i, String... args) { return "works!"; }

    public static void main(String[] args) throws Throwable {
        Method method = Main.class.getMethod("test", int.class, String[].class);
        System.out.println(new Invoker(method).execute(null, new Object[]{1, new String[] {"foo", "bar"} }));
    }

    public static class Invoker {
        private final MethodHandle handle;

        public Invoker(final Method delegate) throws Exception {
            MethodHandle handle = MethodHandles.lookup().unreflect(delegate);
            if (Modifier.isStatic(delegate.getModifiers())) { // for easy static methods support
                handle = MethodHandles.dropArguments(handle, 0, Object.class);
            }
            this.handle = handle.asFixedArity();
        }

        public Object execute(Object target, Object[] args) throws Throwable {
            Object[] allArgs = new Object[args.length + 1];
            allArgs[0] = target;
            System.arraycopy(args, 0, allArgs, 1, args.length);
            return handle.invokeWithArguments(allArgs);
        }
    }
}