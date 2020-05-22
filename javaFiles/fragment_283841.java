public abstract class AbstractDevice implements Device {
    public static abstract class Builder<T, B> {
        public abstract B self();
        public abstract T build();
        public B example(String value) {
            // do something with value
            return self();
        }
    }
}