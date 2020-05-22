interface Instantiator<T extends OtherClass<?>> extends Runnable {
    default <M extends MyClass<?,? extends T>> M get(Supplier<? extends M> s) {
        return s.get();
    }
    static <X extends OtherClass<?>> Instantiator<X> i() {
        return ()->{};
    }
}