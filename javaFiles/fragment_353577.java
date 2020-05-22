static Stream<Arguments> stringArrayProvider() {
    return Stream.of(
            Arguments.of((Object) new String[]{"1", "2"}),
            Arguments.of((Object) new String[]{"1", "2", "3"})
    );
}