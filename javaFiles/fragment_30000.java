interface Processor<T extends Client<T>> extends BiFunction<T, Message,  Boolean> {
    AtomicReference<Boolean> ok = new AtomicReference<>(false);

    default void doJob(T client, Message message) {
        if (apply(client, message))
            ok.set(true);
    }

    default boolean isDone() {
        return ok.get();
    }
}