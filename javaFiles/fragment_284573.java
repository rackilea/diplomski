@Test
public void testSetDay_positive() {
    String testInput = "23\n";
    Scanner testScanner = new Scanner(testInput);
    NameOfTheDay notd = new NameOfTheDay();
    notd.setDay(testScanner);
    Assert.assertEquals(23, notd.getDay()); // or whatever condition to test
}