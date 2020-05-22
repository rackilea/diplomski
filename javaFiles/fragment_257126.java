public class Test<T> {
    public Test() {
        this((Supplier) () -> true);
    }

    public Test(Supplier<T> c) {
        this.c = c;
    }
}