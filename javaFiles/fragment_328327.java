@Test
public void testRodneCisloRok() {
    try {
       new RodneCislo("891415",dopocitej("891415"));
       fail("expected an exception");
    } catch (IllegalArgumentException ex) {
       assertEquals("error1", ex.getMessage());
    }
}