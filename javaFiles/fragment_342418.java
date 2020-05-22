@Test
  public void testSetDescription() {
    Room instance = new Room("test");
    instance.setDescription("abc\n");
    assertEquals("abc*", instance.getDescription());
  }