Map<String, String> map = new HashMap<>();
map.put("hello", "helLo");
map.put("Foo", "bar");

Map<String, String> filtered = Maps.filterEntries(map, new Predicate<Map.Entry<String, String>>() {
    @Override
    public boolean apply(Map.Entry<String, String> input) {
        return !input.getKey().equalsIgnoreCase(input.getValue());
    }
});

System.out.println(filtered); // will print {Foo=bar}