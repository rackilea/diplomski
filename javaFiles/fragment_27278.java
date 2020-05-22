DateTime now = new DateTime(DateTimeZone.forID("UTC"));
DateTime saturday = now.withDayOfWeek(6);
if (saturday.isAfter(now)) {
    saturday = saturday .minusWeeks(1);
}
System.out.println(saturday);