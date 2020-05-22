interface D extends B, C {
    @Override
    default void method() {
        B.super.method();
    }
}