public class ProcedureContainer<S, T> {

    protected final Procedure<S, T> procedure;

    protected ProcedureContainer(final Procedure<S, T> procedure) {
        this.procedure = procedure;
    }

    public static <S, R> ProcedureContainer<S, R> initializeContainer(
            final Function<S, R> initialDataRetriever) {

        Procedure<S, R> initializer = (paramContainer) -> {
            R initialValue = initialDataRetriever.apply(paramContainer);
            return ValueContainer.of(initialValue);
        };
        return new ProcedureContainer<>(initializer);
    }

    public <R> ProcedureContainer<S, R> map(final BiFunction<S, T, R> mapper) {
        return new ProcedureContainer<>(procedure.andThen(mapper));
    }

    public BranchProcedureContainer<S, T, T> branch(final BiPredicate<S, T> predicate) {

        return BranchProcedureContainer.branch(procedure, predicate);
    }

    public Consumer<S> terminate(final BiConsumer<S, T> consumer) {
        return (param) -> {
            ValueContainer<T> finalValue = procedure.procede(param);
            if (finalValue.isTerminated())
                return;

            consumer.accept(param, finalValue.getValue());
        };
    }
}