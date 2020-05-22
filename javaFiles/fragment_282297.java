@Test
public void testConstructor() {
    Flight f = new Flight("00:0j", "ARRIVAL", "A001");
    assertNull(f.scheduledTime);
    assertEquals("A001", f.identifier); 
    // other asserts
}