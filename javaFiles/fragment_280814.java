for (int i = 0; i < outerSize; ++i) {
    List<Integer> inner = new ArrayList<>(innerSize);
    for (int j = 0; i < innerSize; ++i) {
        inner.add(defaultValue);
    }
    list.add(inner);
}