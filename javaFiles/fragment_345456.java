public enum DataType {
    DATETIME("dd/dd/dddd dd:dd:dd"),
    DATE("dd/dd/dddd",
    EMAIL("\\w+@\\w+"),
    TEXT(".*");

    private final Predicate<String> tester;
    DateType(String regexp) {
        tester = Pattern.compile(regexp).asPredicate();
    }

    public static Optional<DataType> getTypeOfField(String[] fieldValues) {
        return Arrays.stream(values())
            .filter(dt -> Arrays.stream(fieldValues).allMatch(dt.tester)
            .findFirst();
    }
}