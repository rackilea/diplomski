@Test
   public void testConstructor() {

    try {
          new Flight("00:0j", "ARRIVAL", "A001");
          fail("Expected exception");
    } catch(Exception e) {
           assertNotNull(e);
        } 
}