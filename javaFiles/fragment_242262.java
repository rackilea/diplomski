private String values(Map<?, ?> map) {
    StringBuilder b = new StringBuilder();
    for(Object value: map.valueSet()) {
        b.append(value).append("\n");
        // append can take an Object; it calls toString on it.
    }
    return b.toString();
}