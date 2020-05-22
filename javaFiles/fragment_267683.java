enum Person{

    cat1("abc"),
    cat2("def", "gh1");

    private static final  Set<Person> ALL = EnumSet.allOf(Person.class);

    private String[] dummy;

    Person(String... dummy) {
        this.dummy = dummy;
    }

    public static Person byVal(String val) {

        return ALL
                .stream()
                .filter(x -> Arrays.stream(x.dummy).anyMatch(y -> y.equalsIgnoreCase(val)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Not found : " + val));
    }

}