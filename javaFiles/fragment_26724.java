private static final Map<String, Types> typeMap = new HashMap<String, Types>();
static {
    for (Types types : values()) {
        typeMap.put(types.type, types);
    }
}

public static Types searchByType(String type) {
    return typeMap.get(type);
}