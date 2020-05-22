public static <T extends Enum<T>> EnumSet<T> getEnumValuesForFlags(
        Class<T> enumType,
        byte[] flags) {

    T[] values = enumType.getEnumConstants();

    return BitSet.valueOf(flags).stream()
        .filter(n -> n < values.length) // bounds check
        .mapToObj(n -> values[n])
        .collect(Collectors.toCollection(() -> EnumSet.noneOf(enumType)));
}