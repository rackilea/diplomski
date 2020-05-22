Predicate<Map.Entry<String, String>> keyEqualsValueIgnoreCase = new Predicate<Map.Entry<String, String>>() {
    @Override
    public boolean apply(Map.Entry<String, String> input) {
        return input.getKey().equalsIgnoreCase(input.getValue());
    }
};

if (Iterables.any(map.entrySet(), keyEqualsValueIgnoreCase)) {
    throw new IllegalStateException();
}