@Test
public void testMirror() {
    String me = "I am ugly and not handsome.";
    String actual = me.replace(" and ", ", ");
    String expected = "I am ugly, not handsome.";
    Assert.assertEquals("hmm", expected, actual);
}