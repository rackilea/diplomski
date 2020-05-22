public interface MethodFunctionArgs<T> {
    T call(Object... params);
    static String someMethod(String arg1, int arg2) { return ""; }
    // does not work
    MethodFunctionArgs<String> func = MethodFunctionArgs::someMethod;
}