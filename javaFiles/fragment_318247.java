public class Test8 {
    public static void main(String[] args) {
        MyObj[] testData = {
                new MyObj(1, "X", 3.14, "Larry"),
                new MyObj(2, "X", 3.14, "Curly"),
                new MyObj(3, "X", 3.14, "Moe"),
        };
        System.out.println("A = " + findCommon(testData, MyObj::getA).orElse(null));
        System.out.println("B = " + findCommon(testData, MyObj::getB).orElse(null));
        System.out.println("C = " + findCommon(testData, MyObj::getC).orElse(null));
        System.out.println("D = " + findCommon(testData, MyObj::getD).orElse(null));
    }
    private static <T, R> Optional<R> findCommon(T[] data, Function<? super T, ? extends R> getterMethod) {
        Set<R> values = Arrays.stream(data)
                              .map(getterMethod)
                              .collect(Collectors.toSet());
        return (values.size() == 1
                ? Optional.ofNullable(values.iterator().next())
                : Optional.empty());
    }
}
class MyObj {
    private final int    a;
    private final String b;
    private final double c;
    private final String d;
    MyObj(int a, String b, double c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public int getA() {
        return this.a;
    }
    public String getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }
    public String getD() {
        return this.d;
    }
}