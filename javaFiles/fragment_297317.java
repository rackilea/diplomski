private boolean[] toPrimitiveArray(final List<Boolean> booleanList) {
    final boolean[] primitives = new boolean[booleanList.size()];
    int index = 0;
    for (Boolean object : booleanList) {
        primitives[index++] = object;
    }
    return primitives;
}