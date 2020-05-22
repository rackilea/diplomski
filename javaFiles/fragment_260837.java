private static String anyArrayToString(Object someArray) {
    if (!someArray.getClass().isArray()) {
        throw new IllegalArgumentException("someArray is not an array!");
    }
    return "[" + IntStream.range(0, Array.getLength(someArray))
                     .mapToObj(i -> Objects.toString(Array.get(someArray, i)))
                     .reduce("", (l, r) -> l+", "+r)
               + "]";
}