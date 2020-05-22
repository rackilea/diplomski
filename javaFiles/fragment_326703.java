for (int i = 0; i < split.length; i++) {
    int remainderLength = split.length - 1 - i;
    String[] remainders = new String[remainderLength];
    if (remainderLength > 0) {
        System.arraycopy(split, i + 1, remainders, 0, remainderLength);
    }
    map.put(split[i], remainders);
}