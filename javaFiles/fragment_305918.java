class NamedPredicate {
    final String name;
    final IntPredicate predicate;

    NamedPredicate(String name, IntPredicate predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    NamedPredicate and(NamedPredicate other) {
        return new NamedPredicate(this.name + " and " + other.name,
                this.predicate.and(other.predicate));
    }
}