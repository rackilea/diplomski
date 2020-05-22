@Test
public void createMakesNewBoy() {
    Info testInfo = new Info();
    Girl toTest = new Girl(testInfo);
    Boy created = toTest.create("param");
    assertEquals("param", created.getParam());
    assertSame(testInfo, created.getInfo());
}