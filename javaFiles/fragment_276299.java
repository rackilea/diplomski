static class StatsCollector implements Collector<Data, Stats, Stats> {
    @Override
    public Supplier<Stats> supplier() {
        return Stats::new;
    }

    @Override
    public BiConsumer<Stats, Data> accumulator() {
        return (stats, data) -> {
            stats.noOfVehiclesSum += data.noOfVehicles;
            stats.totalTaxSum += data.totalTax;
            stats.count += 1;
        };
    }

    @Override
    public BinaryOperator<Stats> combiner() {
        return (lft, rght) -> {
            lft.noOfVehiclesSum += rght.noOfVehiclesSum;
            lft.totalTaxSum += rght.totalTaxSum;
            lft.count += rght.count;
            return lft;
        };
    }

    @Override
    public Function<Stats, Stats> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Collector.Characteristics.IDENTITY_FINISH);
    }
}