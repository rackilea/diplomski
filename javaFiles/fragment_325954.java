@Test
public void testDate() {
    LocalDateTime time = LocalDateTime.now();
    MyObject object = new MyObject(() -> time);
    object.myMethod();
    Assert.assertTrue(time.isEqual(object.getDate()));
}