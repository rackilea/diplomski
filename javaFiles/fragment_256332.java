public class Base {

    private final Map<Character, Method> methods = new HashMap<Character, Method>();

    public Base() throws SecurityException, NoSuchMethodException {
        methods.put('A', getClass().getMethod("method1"));
        methods.put('B', getClass().getMethod("method2"));
        methods.put('C', getClass().getMethod("method3"));
    }

    public Method getMethod(char c) {
        return methods.get(c);
    }

    public void method1() {}

    public void method2() {}

    public void method3() {}

}