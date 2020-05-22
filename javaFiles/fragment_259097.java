@Test
public void testGetDaysUntil() {
    A instanceUnderTest = new A();
    for (int daysToTest = 0; daysToTest <= 400; daysToTest++) {

        LocalDate today;
        int result;
        do {
            today = LocalDate.now(); // do this in each iteration in case day changes underway
            LocalDate targetDate = today.plusDays(daysToTest);
            Date midnightAtStartOfDay = Date.from(targetDate.atStartOfDay(ZoneId.systemDefault())
                                                    .toInstant());
            result = instanceUnderTest.getDaysUntil(midnightAtStartOfDay);
        } while (! today.equals(LocalDate.now())); // if we have passed midnight, try again
        assertEquals(daysToTest, result);

        do {
            today = LocalDate.now();
            LocalDate targetDate = today.plusDays(daysToTest);
            Date nearMidnightAtEndOfDay = Date.from(targetDate.atTime(23, 59, 59, 400_000_000)
                                                        .atZone(ZoneId.systemDefault())
                                                        .toInstant());
            result = instanceUnderTest.getDaysUntil(nearMidnightAtEndOfDay);
        } while (! today.equals(LocalDate.now()));
        assertEquals(daysToTest, result);
    }
}