public class Data {
    private final Integer a;
    private final String b;

    private Data(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    @Override
    public String toString() {
        return "[" + a + ", '" + b + "']";
    }
}