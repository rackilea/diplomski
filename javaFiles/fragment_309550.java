abstract class AbstractRule<T> implements Rule<T> {
    Set<Criteria<T>> criteria;

    @Override
    @Nullable
    public Predicate<T> evaluate() {
        return criteria.stream().map(Criteria::evaluate)
                                .reduce(Predicate::and)
                                .orElse(null);
    }
}