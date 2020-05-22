class C<T extends Number> {
    int consume(T t) {
        return t.intValue(); // NOT OK since T could be nullable
    }
    T provide() {
        return null;         // NOT OK since T could require nonnull
    }
}