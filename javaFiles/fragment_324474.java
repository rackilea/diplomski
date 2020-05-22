@Test
void testTimestampConversion() {

    Calendar cal = Calendar.getInstance(Locale.ENGLISH);

    // Present
    long expected = dateToTimestamp(cal.getTime());
    assertEquals(expected, dateToTimestamp(timeStampToDate(expected)));

    // Past
    long expectedPast = 1000;
    assertEquals(expectedPast, dateToTimestamp(timeStampToDate(expectedPast)));

    // Future
    Date future = cal.getTime();
    future.setYear(3000);
    long expectedFuture = dateToTimestamp(future);
    assertEquals(expectedFuture, dateToTimestamp(timeStampToDate(expectedFuture)));
}