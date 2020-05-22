String input = "2014-03-09 02:00:00.000";
LocalDateTime ldt = FORMATTER.parseLocalDateTime(input); // always working
System.out.println(ldt); // 2014-03-09T02:00:00.000
DateTime result;

try {
    result = ldt.toDateTime(EASTERN);
} catch (IllegalInstantException ex) {
    result = ldt.plusHours(1).toDateTime(EDT); // simulates a PUSH-FORWARD-strategy at gap
    // result = ldt.toDateTime(EST); // the same instant but finally display with EST offset
}
System.out.println(result); // 2014-03-09T03:00:00.000-04:00
// if you had chosen <<<ldt.toDateTime(EST)>>> then: 2014-03-09T02:00:00.000-05:00