private Pattern p = Pattern.compile("\\d+(\\.\\d+)?");

@Test
public void testInteger() {
    Matcher m =p.matcher("10");

    assertTrue(m.find());
    assertEquals("10", m.group());
}

@Test
public void testDecimal() {
    Matcher m =p.matcher("10.99");

    assertTrue(m.find());
    assertEquals("10.99", m.group());
}