Map<String, Object> map = new HashMap<>();
for (Entry<String, Object> entry : new HashSet<>(map.entrySet())) {
    String trimmed = entry.getKey().trim();
    if (!trimmed.equals(entry.getKey())) {
        map.remove(entry.getKey());
        map.put(trimmed, entry.getValue());
    }
}