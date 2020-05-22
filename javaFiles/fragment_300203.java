@Test
public void test() throws Exception {
    Deencapsulation.setField(foo, "field", "24601");

    char c = foo.getFirstChar();

    assertThat(c, is('2'));
}