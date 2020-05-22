@Test
@Config(configuration = TestConfig.NO_CONFIG)
public void equalityTest() {
    MyObject a = new MyObject(BigDecimal.TEN);
    MyObject b = a;

    assertThat(a.hashCode(), is(b.hashCode()));
    assertTrue(a.equals(b));

    // Force an offset
    DateTimeUtils.setCurrentMillisOffset(1000);
    b = new MyObject(BigDecimal.TEN);
    // Clears the offset
    DateTimeUtils.setCurrentMillisSystem();

    assertThat(a, is(not(b)));
}