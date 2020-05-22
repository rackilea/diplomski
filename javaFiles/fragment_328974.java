private static final TypeToken<Map<?, ? extends Number>> T =
    new TypeToken<Map<?, ? extends Number>>() {};

private static boolean isNumericValue(ParameterizedType t) {
    return T.isSupertypeOf(t);
}