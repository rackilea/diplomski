@Test
public void advanceByMax1HourWithoutOverflow() {
    /*
    27 October 2018
    1540648800000 -> 1540652400000
    22:00 -> 23:00
    */
    long currentTimeMillis = 1540648800000L;
    long expected = 1540652400000L;
    long output = Utils.advanceByMax1HourWithoutOverflow(currentTimeMillis);
    assertEquals(expected, output);
}