@Test
public void testToString() {
    System.out.println("toString");
    Address instance = new Address();
    instance.setStreet("Somestreet");
    instance.setCity("Somecity");
    instance.setPostcode("12345");
    String expResult = "SomestreetSomecity12345";
    String result = instance.toString();
    assertEquals(expResult, result);
}