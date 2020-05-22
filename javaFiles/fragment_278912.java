private static int countFrequencies(Map<String, Object> list, Object o) {
    int totalCount = 0;
    Collection<Object> values = list.values();
    for (Object v : values) {
        if (o == null) {
            if (v == null) totalCount++;
        } else {
            if (Objects.nonNull(v) && v.equals(o)) {
                totalCount++;
            }
        }
    }
    return totalCount;
}