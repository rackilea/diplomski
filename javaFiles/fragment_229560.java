private static final Map<String, BiConsumer<Data, String>> MAP = new LinkedHashMap<>();
static {
    MAP.put("ServerAdmin", Data::setServerAdmin);
    MAP.put("DocumentRoot", Data::setDocumentRoot);
    // ...
}
public void foo(Data data, String s) {
    MAP.entrySet().stream()
        .filter(entry -> s.contains(entry.getKey()))
        .findFirst()
        .ifPresent(entry -> entry.getValue().accept(data, s));
}