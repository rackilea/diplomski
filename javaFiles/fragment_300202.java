@Test
public void test() throws Exception {
    new Expectations(foo) {{
        foo.getField(); result = "24601";
    }};

    char c = foo.getFirstChar();

    assertThat(c, is('2'));
}