@Test
public void testMonth() {
    String expected = "feb";
    String actual = ex2.month(2);

    assertEquals(expected, actual);
}