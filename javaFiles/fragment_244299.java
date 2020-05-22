public <In, Out, A> BiFunction<In, Out, Out> weave(
     Function<? super In, A> getter,
     BiConsumer<? super Out, ? super A> consumer) {

    MethodHandles.Lookup l = MethodHandles.lookup();
    try {
        MethodHandle target = l.findStatic(l.lookupClass(), "weaveLambdaBody",
            MethodType.methodType(Object.class, Function.class, BiConsumer.class,
                Object.class, Object.class));
        MethodType t = target.type().dropParameterTypes(0, 2);
        return (BiFunction<In, Out, Out>)LambdaMetafactory.metafactory(l, "apply",
            target.type().dropParameterTypes(2, 4).changeReturnType(BiFunction.class),
            t, target, t) .getTarget().invokeExact(getter, consumer);
    }
    catch(RuntimeException | Error e) {
        throw e;
    }
    catch(Throwable t) {
        throw new IllegalStateException(t);
    }
}
private static <In, Out, A> Out weaveLambdaBody(
    Function<? super In, A> getter,
    BiConsumer<? super Out, ? super A> consumer,
    In in, Out out) {

    consumer.accept(out, getter.apply(in));
    return out;
}