static Map<Integer, Color> mapOfColord = new HashMap<>();

static {
    Map<Integer, Color> colors = new HashMap<>();
    for (Color color : Color.values()) {
        colors.put(color.colorCode, color);
    }
    mapOfColord = Collections.unmodifiableMap(colors);
}