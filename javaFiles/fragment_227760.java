public class Super {
    public static void main(String... args) throws Exception {
        for (Method method : Sub.class.getDeclaredMethods())
            System.out.println(method + (method.isSynthetic() ? " **SYNTHETIC**" : ""));
    }
    public Number get() {
        return Double.NaN;
    }
}
class Sub extends Super {
    @Override
    public Integer get() {
        return 42;
    }
}