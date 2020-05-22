static ZoneId zone = ZoneId.of("America/Monterrey");
static LocalTime dayStart = LocalTime.of(6, 0);
static LocalTime dayEnd = LocalTime.of(22, 0);
static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/uuuu H:mm");

public static void main(String[] args) {

    String workStartString = "28/03/2018 03:00";
    String workEndString = "29/03/2018 23:30";
    calculateWorkingHours(workStartString, workEndString);
}

public static void calculateWorkingHours(String workStartString, String workEndString) {
    ZonedDateTime workStart
            = LocalDateTime.parse(workStartString, formatter).atZone(zone);
    ZonedDateTime workEnd
            = LocalDateTime.parse(workEndString, formatter).atZone(zone);

    if (workEnd.isBefore(workStart)) {
        throw new IllegalArgumentException("Work end must not be before work start");
    }

    LocalDate workStartDate = workStart.toLocalDate();
    LocalDate workEndDate = workEnd.toLocalDate();

    Duration workedDaytime = Duration.ZERO;
    // first calculate work at nighttime before the start date, that is, work before 06:00
    Duration workedNighttime 
            = calculateNightTime(workStartDate.minusDays(1), workStart, workEnd);

    for (LocalDate d = workStartDate; ! d.isAfter(workEndDate); d = d.plusDays(1)) {
        workedDaytime = workedDaytime.plus(calculateDayTime(d, workStart, workEnd));
        workedNighttime = workedNighttime.plus(calculateNightTime(d, workStart, workEnd));
    }

    double dayHours = workedDaytime.toMinutes() / (double) TimeUnit.HOURS.toMinutes(1);
    double nightHours = workedNighttime.toMinutes() / (double) TimeUnit.HOURS.toMinutes(1);

    System.out.println("Day " + dayHours + " hours; night " + nightHours + " hours");

}

/**
 * Calculates amount of work in daytime on d,
 * that is between 06:00 and 22:00 on d.
 * Only time that falls with in workStart to workAnd
 * and also falls within 06:00 to 22:00 on d is included.
 * 
 * @param d The date for which to calculate day work
 * @param workStart
 * @param workEnd
 * @return Amount of daytime work on the said day
 */
private static Duration calculateDayTime(LocalDate d, ZonedDateTime workStart, ZonedDateTime workEnd) {
    ZonedDateTime dayStartToday = d.atTime(dayStart).atZone(zone);
    ZonedDateTime dayEndToday = d.atTime(dayEnd).atZone(zone);
    if (workStart.isAfter(dayEndToday) || workEnd.isBefore(dayStartToday)) {
        return Duration.ZERO;
    }

    // restrict calculation to daytime on d
    if (workStart.isBefore(dayStartToday)) {
        workStart = dayStartToday;
    }
    if (workEnd.isAfter(dayEndToday)) {
        workEnd = dayEndToday;
    }

    return Duration.between(workStart, workEnd);
}

/**
 * Calculates amount of night work in the night after d,
 * that is from 22:00 on d until 06:00 the next morning.
 * 
 * @param d The date for which to calculate night work
 * @param workStart
 * @param workEnd
 * @return Amount of nighttime work in said night
 */
private static Duration calculateNightTime(LocalDate d, ZonedDateTime workStart, ZonedDateTime workEnd) {
    assert ! workEnd.isBefore(workStart);

    ZonedDateTime nightStart = d.atTime(dayEnd).atZone(zone);
    ZonedDateTime nightEnd = d.plusDays(1).atTime(dayStart).atZone(zone);

    if (workEnd.isBefore(nightStart) || workStart.isAfter(nightEnd)) {
        return Duration.ZERO;
    }

    // restrict calculation to the night after d
    if (workStart.isBefore(nightStart)) {
        workStart = nightStart;
    }
    if (workEnd.isAfter(nightEnd)) {
        workEnd = nightEnd;
    }

    return Duration.between(workStart, workEnd);
}