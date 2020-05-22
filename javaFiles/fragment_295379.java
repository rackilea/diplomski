static final Map<String, Integer> modes = new HashMap<>();
static {
    modes.put("HEAT", 16);
    modes.put("WIND", 8);
    // ...
}

void someMethod(String mode) {
    // ...
    if (modes.containsKey(mode))
        firstPart += modes.get(mode);
}