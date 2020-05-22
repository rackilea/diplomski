public interface Foo<T> {
    public interface Bar<U> {
        public void bar(U t);
    }

    public void addListener(Bar<T> listener);
}