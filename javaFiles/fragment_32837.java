import static java.util.AbstractMap.SimpleImmutableEntry;

...

enum Food {
    APPLE, APPLE2, APPLE3, BANANA, PINEAPPLE, CUCUMBER;

    private static final Map<String, Food> MAP = Stream.concat(
                Stream.of(APPLE, APPLE2, APPLE3).map(e -> new SimpleImmutableEntry<>(e.name().toLowerCase(), APPLE)),
                Stream.of(BANANA, PINEAPPLE, CUCUMBER).map(e -> new SimpleImmutableEntry<>(e.name().toLowerCase(), e)))
            .collect(toMap(SimpleImmutableEntry::getKey, SimpleImmutableEntry::getValue));

    public static Food fromValue(String value) {
        return MAP.get(value.toLowerCase());
    }
}