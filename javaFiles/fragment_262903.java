class Foo {
    private final Map<String, String> map = new HashMap<String, String>();

    void add(String string) {
        map.put(string, "a value");
    }

    void clear() {
        map.clear();
    }
}