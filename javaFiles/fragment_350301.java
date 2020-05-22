public static <T, A1, A2, R1, R2, R> Collector<T, ?, R> teeing(
        Collector<? super T, A1, R1> downstream1,
        Collector<? super T, A2, R2> downstream2,
        BiFunction<? super R1, ? super R2, R> merger) {

    class Acc {
        A1 acc1 = downstream1.supplier().get();
        A2 acc2 = downstream2.supplier().get();

        void accumulate(T t) {
            downstream1.accumulator().accept(acc1, t);
            downstream2.accumulator().accept(acc2, t);
        }

        Acc combine(Acc other) {
            acc1 = downstream1.combiner().apply(acc1, other.acc1);
            acc2 = downstream2.combiner().apply(acc2, other.acc2);
            return this;
        }

        R applyMerger() {
            R1 r1 = downstream1.finisher().apply(acc1);
            R2 r2 = downstream2.finisher().apply(acc2);
            return merger.apply(r1, r2);
        }
    }

    return Collector.of(Acc::new, Acc::accumulate, Acc::combine, Acc::applyMerger);
}