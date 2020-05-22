interface Mutation<T> {
    void apply(T subject);
}

    <T> Collection<? extends T> mutate(Collection<? extends T> input, Mutation<? super T> mutation) {
        for (T element : input) {
            mutation.apply(element);
        }
        return input;
    }