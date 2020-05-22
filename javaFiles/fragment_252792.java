public static <S, T> List<Map<S, T>> unravel(Map<S, List<T>> org) {
    List<Map<S, T>> out = new LinkedList<>();

    for (Entry<S, List<T>> entry : org.entrySet()) {
        if (entry.getValue() == null || entry.getValue().isEmpty()) {
            continue;
        }
        while (out.size() < entry.getValue().size()) {
            out.add(new HashMap<S, T>());
        }
        for (int i = 0, size = entry.getValue().size(); i < size; i++) {
            T value = entry.getValue().get(i);

            if (value == null) {
                continue;
            }

            out.get(i).put(entry.getKey(), value);
        }
    }

    return out;
}