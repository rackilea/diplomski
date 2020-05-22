private static Stream<Object> flatMapDynamicArray(Object[] array) {
    return Arrays.stream(array)
            .flatMap(o -> o.getClass().isArray() ? 
                    flatMapDynamicArray((Object[]) o) : 
                    Stream.of(o));
}