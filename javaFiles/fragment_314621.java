public final class ClassName {
    private final int a;
    private final double b;
    public ClassName(int a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString() {
        return this.a + " : " + this.b;
    }
}