Map<String, Consumer<String>> map = new LinkedHashMap<>();
map.put("ServerAdmin", data::setServerAdmin);
map.put("DocumentRoot", data::setDocumentRoot);
// ...
map.entrySet().stream()
    .filter(entry -> s.contains(entry.getKey()))
    .findFirst()
    .ifPresent(entry -> entry.getValue().accept(s));