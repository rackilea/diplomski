@CartesianProductTest({"0", "1"})
void threeBits(String a, String b, String c) {
    int value = Integer.parseUnsignedInt(a + b + c, 2);
    assertTrue((0b000 <= value) && (value <= 0b111));
}

@CartesianProductTest
@DisplayName("S ⨯ T ⨯ U")
void nFold(String string, Class<?> type, TimeUnit unit, TestInfo info) {
    assertTrue(string.endsWith("a"));
    assertTrue(type.isInterface());
    assertTrue(unit.name().endsWith("S"));
    assertTrue(info.getTags().isEmpty());
}

static CartesianProductTest.Sets nFold() {
    return new CartesianProductTest.Sets()
            .add("Alpha", "Omega")
            .add(Runnable.class, Comparable.class, TestInfo.class)
            .add(TimeUnit.DAYS, TimeUnit.HOURS);
}