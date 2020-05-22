@Test
public void testSetDay_negative_then_positive() {
    String testInput = "999\n23\n"; // two lines of input here
    Scanner testScanner = new Scanner(testInput);
    NameOfTheDay notd = new NameOfTheDay();
    notd.setDay(testScanner);
    Assert.assertEquals(23, notd.getDay()); // or whatever condition to test
}