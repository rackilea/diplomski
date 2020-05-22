class Test {
    public static int doSomething(int a, int b, int c) {
        return a + b + c;
    }
    // This variable holds method reference to doSomething
    private static Method doSomethingMethod;
    // We initialize this variable in a static initialization block
    static {
        try {
            doSomethingMethod = Test.class.getMethod("doSomething", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        } catch (Exception e) {
        }
    }
    public static void main (String[] ignore) throws java.lang.Exception {
        // Note that args is Object[], not int[]
        Object[] args = new Object[] {1, 2, 3};
        // Result is also Object, not int
        Object res = doSomethingMethod.invoke(null, args);
        System.out.println(res);
    }
}