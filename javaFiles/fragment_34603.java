@Test
public void twoDaysAndAHalf(){
    final int secondsInDay = 60 * 60 * 24;
    assertEquals("2 days and 12:00:00",
        OurDateTimeFormatter.format(1000 * secondsInDay * 5 / 2));
}