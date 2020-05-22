public class Test {
    public Test() {
        this((Supplier) () -> true);
    }

    public Test(Supplier<?> c) {
        this.c = c;
    }
}