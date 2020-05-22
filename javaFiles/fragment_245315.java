@ParameterizedTest(name = "{index} {1}")
@MethodSource("argumentProvider")
public void testSomething(Object someObject, String niceRepresentation) {
    // Test something
}

private static Stream<Arguments> argumentProvider() {
    return Stream.of(
            Arguments.of(new Object(), "Nice 1"),
            Arguments.of(new Object(), "Nice 2")
    );
}