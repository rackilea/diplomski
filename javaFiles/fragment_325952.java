@Test
public void testDate() {
    MyObject object = new MyObject();
    // Get the current date time 
    LocalDateTime time = LocalDateTime.now();
    // Affect the current date time to the field date
    object.myMethod();
    // Make sure that it is before or equals
    Assert.assertTrue(time.isBefore(object.getDate()) || time.isEqual(object.getDate()));
}