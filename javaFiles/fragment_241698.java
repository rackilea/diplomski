@Test
@Config(configuration = TestConfig.NO_CONFIG)
public void equalityTest() {
    MyObject a = new MyObject(BigDecimal.TEN);
    MyObject b = a;

    assertThat(a.hashCode(), is(b.hashCode()));
    assertTrue(a.equals(b));

    try {
        Thread.sleep(0, 1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    b = new MyObject(BigDecimal.TEN);

    // Line that was failing
    assertThat(a, is(not(b)));
}