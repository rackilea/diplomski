/** Extending interfaces must have a method called consume with N args */
interface NConsumer {}

/*
 * Method must be called consume for reflection.
 *
 * You can define N interfaces like this.
 */
nterface TriConsumer<A, B, C> extends NConsumer {
    void consume(A a, B b, C c);
}

interface ArrayCaller<E extends NConsumer> {
    void call(E code);
    static <T extends NConsumer> ArrayCaller<T> convert(Supplier<?>...argSuppliers) {
        final Object[] args = new Object[argSuppliers.length];
        for (int i = 0; i < argSuppliers.length; i++) {
            args[i] = argSuppliers[i].get();
        }
        return new ArrayCaller<T>() {
            @Override
            public void call(T code) {
                for (Method m: code.getClass().getMethods()) {
                    if (m.getName().equals("consume")) {
                        try {
                            m.invoke(code, args);
                        } catch (IllegalAccessException
                                | IllegalArgumentException
                                | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
    }
}