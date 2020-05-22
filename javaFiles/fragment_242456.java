private static final Map<String, FragmentName> map = new HashMap<>();
static {
    for (FragmentName en : values()) {
        map.put(en.text, en);
    }
}

public static FragmentName valueFor(String name) {
    return map.get(name);
}