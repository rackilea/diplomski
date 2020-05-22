public class BranchProcedureContainer<S, T, R> {

    private final Procedure<S, T> baseProcedure;
    private final BiPredicate<S, T> predicate;
    private final BiFunction<S, ValueContainer<T>, ValueContainer<R>> branchProcedure;

    private BranchProcedureContainer(
            final Procedure<S, T> baseProcedure,
            final BiPredicate<S, T> predicate,
            final BiFunction<S, ValueContainer<T>, ValueContainer<R>> branchProcedure) {

        this.baseProcedure = baseProcedure;
        this.predicate = predicate;
        this.branchProcedure = branchProcedure;
    }

    protected static <S, T> BranchProcedureContainer<S, T, T> branch(
            final Procedure<S, T> baseProcedure,
            final BiPredicate<S, T> predicate) {

        return new BranchProcedureContainer<>(baseProcedure, predicate, (s, v) -> v);
    }

    public <RR> BranchProcedureContainer<S, T, RR> map(
            final BiFunction<S, R, RR> mapper) {

        BiFunction<S, ValueContainer<T>, ValueContainer<RR>> fullMapper = (s, vT) -> {
            if (vT.isTerminated())
                return ValueContainer.<RR>terminated();

            ValueContainer<R> intermediateValue = branchProcedure.apply(s, vT);
            if (intermediateValue.isTerminated())
                return ValueContainer.<RR>terminated();

            RR finalValue = mapper.apply(s, intermediateValue.getValue());
            return ValueContainer.of(finalValue);
        };
        return new BranchProcedureContainer<>(baseProcedure, predicate, fullMapper);
    }

    public ProcedureContainer<S, T> endBranch(final BiConsumer<S, R> consumer) {

        Procedure<S, T> mergedBranch = (state) -> {
            ValueContainer<T> startingPoint = baseProcedure.procede(state);
            if (startingPoint.isTerminated())
                return ValueContainer.<T>terminated();

            if (!predicate.test(state, startingPoint.getValue()))
                return startingPoint;

            ValueContainer<R> intermediateValue = branchProcedure.apply(state, startingPoint);
            if (intermediateValue.isTerminated())
                return ValueContainer.<T>terminated();
            consumer.accept(state, intermediateValue.getValue());
            return ValueContainer.<T>terminated();
        };

        return new ProcedureContainer<>(mergedBranch);
    }
}