@Test
public void testMethodArgIsNull() {
    Sub s = new Sub();
    s.method(null);
    assertThat(s.isSomethingDone(), is(true));
}