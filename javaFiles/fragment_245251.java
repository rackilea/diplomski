public static class SomeObject {

    private final String someString;

    public SomeObject(final String someString) {
        this.someString = someString;
    }

    public String getSomeString() {
        return this.someString;
    }

    @Override
    public String toString() {
        return this.someString;
    }
}

public static final Predicate<SomeObject> CONTAINS_A_FILTER = new Predicate<GuavaExample.SomeObject>() {

    @Override
    public boolean apply(final SomeObject someObject) {

        return someObject.getSomeString()
            .contains("A");
    }
};

public static final Predicate<SomeObject> CONTAINS_B_FILTER = new Predicate<GuavaExample.SomeObject>() {

    @Override
    public boolean apply(final SomeObject someObject) {

        return someObject.getSomeString()
            .contains("B");
    }
};

public static final Predicate<SomeObject> CONTAINS_A_AND_B_FILTER = Predicates.and(CONTAINS_A_FILTER,
        CONTAINS_B_FILTER);

public static final Predicate<SomeObject> CONTAINS_A_OR_B_FILTER = Predicates.or(CONTAINS_A_FILTER,
        CONTAINS_B_FILTER);

public static void main(final String... args) {

   final List<SomeObject> someObjects = ImmutableList.of(new SomeObject("A"), new SomeObject("AB"),
            new SomeObject("B"), new SomeObject("C"));

    final Set<SomeObject> containsAandB = FluentIterable.from(someObjects)
            .filter(CONTAINS_A_AND_B_FILTER)
            .toSet();

    // prints [AB]
    System.out.println(containsAandB);

    final Set<SomeObject> containsAOrB = FluentIterable.from(someObjects)
            .filter(CONTAINS_A_OR_B_FILTER)
            .toSet();

    // prints [A, AB, B]
    System.out.println(containsAOrB);
}