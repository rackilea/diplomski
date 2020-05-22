@Test
public void testConstructor() throws Exception {
    new Expectations() {{
        bar.getValue(); result = 24601;
    }};

    Foo foo2 = new Foo(bar);
    String fieldValue = foo2.getField(); // or use Deencapsulation
    assertThat(fieldValue, is("24601"));
}