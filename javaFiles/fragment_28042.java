public class IntegerRankingCollector<T> implements Collector<T, List<T>, List<T>> {
        ...

    public IntegerRankingCollector(Comparator<? super T> comparator, Function<T, Integer> ranker, BiFunction<T, Integer, T> creator) {
        this.comparator = comparator;
        this.ranker = ranker;
        this.creator = creator;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, current) -> {
            ArrayList<T> right = new ArrayList<>();
            right.add(creator.apply(current, 1));
            combiner().apply(list, right);
        };
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (left, right) -> {
            int rankAdjustment = getRankAdjustment(left, right);
            for (T t : right)
                left.add(creator.apply(t, rankAdjustment + ranker.apply(t)));
            return left;
        };
    }

    private int getRankAdjustment(List<T> left, List<T> right) {
        Optional<T> lastElementOnTheLeft = optGet(left, left.size() - 1);
        Optional<T> firstElementOnTheRight = optGet(right, 0);

        if (!lastElementOnTheLeft.isPresent() || !firstElementOnTheRight.isPresent())
            return 0;
        else if (comparator.compare(firstElementOnTheRight.get(), lastElementOnTheLeft.get()) == 0)
            return ranker.apply(lastElementOnTheLeft.get()) - 1;
        else
            return ranker.apply(lastElementOnTheLeft.get());
    }

    private Optional<T> optGet(List<T> list, int index) {
        if (list == null || list.isEmpty())
            return Optional.empty();
        else
            return Optional.of(list.get(index));
    }

        ...
    }