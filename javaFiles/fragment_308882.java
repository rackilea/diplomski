/** On what day of each month should the count be reset? 1..28 */
private static final int DAY_OF_MONTH_TO_RESET_COUNT = 5;
/** In what time zone should above day-of-month be interpreted? */
private static final ZoneId timeZone = ZoneId.of("Asia/Pontianak");

public static void resetIfDue() {
    // substitute reset_date from DB here
    LocalDate lastResetDate = LocalDate.of(2017, Month.DECEMBER, 5);

    LocalDate nextResetDate = lastResetDate.plusMonths(1)
                                .withDayOfMonth(DAY_OF_MONTH_TO_RESET_COUNT);
    LocalDate today = LocalDate.now(timeZone);
    // "not after today" means today or before today
    if (! nextResetDate.isAfter(today)) {
        System.out.println("Reset the count and update the reset_date in the database");
    }
}