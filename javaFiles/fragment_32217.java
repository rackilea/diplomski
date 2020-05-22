@Test
@Parameters(method = "method1Params")
public void testMethod1(int testValue, int expectedResult) {
    assertThat(testee.method1(testValue), equalTo(expectedResult));
}

@Ignore
private final Object[] method1Params() {
    return new Object[] {
        new Object { 1, 2 },
        new Object { -2, -1 }
    };
}