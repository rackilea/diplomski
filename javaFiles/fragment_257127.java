public class Test<T> {
    public static Test<Boolean> newWithConstantSupplier() {
        return new Test<>(() -> true);
    }

    public Test(Supplier<T> c) {
        this.c = c;
    }
}