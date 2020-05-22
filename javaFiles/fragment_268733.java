abstract class Base {
    abstract static class Builder<T extends Base> {
        private int a;

        Builder<T> setA(int a) {
            this.a = a;
            return this;
        }

        abstract T build();
    }
}