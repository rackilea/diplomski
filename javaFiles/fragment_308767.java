public enum Day {
    SUNDAY("Foo", "Fooz",
           "Bar", "Barz",
           "Hello", "Hi");

    private final Map<String, String> map;

    Day(String... keysAndValues) {
        if ((keysAndValues.length & 1) != 0)
            throw new IllegalArgumentException("keysAndValues has odd size: " + Arrays.toString(keysAndValues));
        this.map = new HashMap<>();
        for (int i = 0; i < keysAndValues.length; i += 2) {
            if (keysAndValues[i] == null || keysAndValues[i + 1] == null)
                throw new NullPointerException();
            if (this.map.put(keysAndValues[i], keysAndValues[i + 1]) != null)
                throw new IllegalArgumentException("keysAndValues has duplicate key named '" + keysAndValues[i] + "': " + Arrays.toString(keysAndValues));
        }
    }

    public Map<String, String> getMap() {
        return this.map;
    }

}