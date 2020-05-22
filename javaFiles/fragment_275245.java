import static one.util.streamex.MoreCollectors.*;

@SafeVarargs
static <T> Collector<T, ?, Boolean> allMatchingOneOf(Predicate<T> first, Predicate<T>... predicates) {
    Collector<T, ?, Boolean> collector = allMatching(first);
    for (Predicate<T> predicate : predicates) {
        collector = pairing(collector, allMatching(predicate), Boolean::logicalOr);
    }
    return collector;
}

static <T> Collector<T, ?, Boolean> allMatching(Predicate<T> pred) {
    return collectingAndThen(anyMatching(pred.negate()), b -> !b);
}

static <T> Collector<T, ?, Boolean> anyMatching(Predicate<T> pred) {
    return collectingAndThen(filtering(pred, first()), Optional::isPresent);
}