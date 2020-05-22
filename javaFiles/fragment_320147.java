private static Properties extractMetadata(NamedComponent component) {
    Entry entry = new Entry();
    String name = component.getComponentName();
    String type = component.getComponentType();
    if (name != null && !name.startsWith("org.springframework.integration")) {
        entry.setName(name);
        if (type != null) {
            entry.setType(type);
        }
    }
    if (!entry.isEmpty()) {
        entry.setTimestamp(Long.toString(System.currentTimeMillis()));
    }
    return entry;
}