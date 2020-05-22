jshell> java.time.format.DateTimeFormatter dmy = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
dmy ==> Value(DayOfMonth,2)'-'Value(MonthOfYear,2)'-'Value(YearOfEra,4,19,EXCEEDS_PAD)

jshell> java.time.LocalDate.parse("13-02-1994", dmy)
$2 ==> 1994-02-13

jshell> java.time.LocalDate.parse("1994-02-13", dmy)
|  java.time.format.DateTimeParseException thrown: Text '1994-02-13' could not be parsed at index 2
|        at DateTimeFormatter.parseResolved0 (DateTimeFormatter.java:1988)
|        at DateTimeFormatter.parse (DateTimeFormatter.java:1890)
|        at LocalDate.parse (LocalDate.java:428)
|        at (#3:1)