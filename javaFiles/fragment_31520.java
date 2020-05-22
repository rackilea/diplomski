private static Map<Integer, Color> mapOfColord = new HashMap<>();

static {
    for (Color color : Color.values()) {
        mapOfColord.put(color.colorCode, color);
    }
}

public static Color getColor(Integer key) {
    return mapOfColord.get(key);
}