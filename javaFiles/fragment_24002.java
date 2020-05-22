private static final Map<String, Type<?>> types = new HashMap<>();
static {
    types.put(MBoolean.getName(), MBoolean);
    types.put(MInteger.getName(), MInteger);
}
private Type(String name) {
    this.name = name;
    // removed types.put(name, this); from here
}