public interface MethodFunctionArgs<T> {
    T call(String arg1, int arg2);
    static String someMethod(Object... params) { return ""; }
    // no problem
    MethodFunctionArgs<String> func = MethodFunctionArgs::someMethod;
}