Map<String, Function<Big, List<String>>> mappers = new HashMap<String, Function<Big, List<String>>>() {
    {
        put("A", a -> Arrays.asList(a.a, a.b));
        put("B", a -> Arrays.asList(a.c, a.d));
    }
};

public List<String> parse(Big input) {
    return mappers.get(input.director).apply(input);
}