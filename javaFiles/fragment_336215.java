@Test
public void isOccurrence() {
    long startTime = System.currentTimeMillis();

    assertTrue(isOccurrence(new DateMidnight(2010, 1, 10), 3, new DateTime(2010, 1, 19, 0, 0)));
    assertFalse(isOccurrence(new DateMidnight(2010, 1, 10), 3, new DateTime(2010, 1, 18, 0, 0)));

    assertTrue(isOccurrence(new DateMidnight(2010, 1, 10), 3, new DateTime(2310, 1, 19, 0, 0)));
    assertFalse(isOccurrence(new DateMidnight(2010, 1, 10), 3, new DateTime(2310, 1, 20, 0, 0)));

    assertTrue(isOccurrence(new DateMidnight(2010, 1, 10), 3, new DateTime(2010, 1, 10, 0, 0)));

    System.out.println("elapsed=" + (System.currentTimeMillis() - startTime));
}

public boolean isOccurrence(DateMidnight startDate, int dayIncrement, DateTime testTime) {
    DateMidnight testDateMidnight = testTime.toDateMidnight();
    while (startDate.isBefore(testDateMidnight)) {
        startDate = startDate.plusDays(dayIncrement);
    }
    return startDate.equals(testDateMidnight);
}