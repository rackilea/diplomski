@Test
@Parameters(method = "reverseValues")
public void reverseString(String input, String output) {
    StringReverse s = new StringReverse();
    assertEquals(output, s.reverse(input));
}

private Object[] reverseValues() {
     return new Object[]{
             new Object[]{"abc", "cba"},
             new Object[]{"", ""}
        };
}