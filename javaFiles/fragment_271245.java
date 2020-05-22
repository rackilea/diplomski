String actual = "18:01:23";
String limit = "00:16:23";

DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss");

DateTime ac = df.parseLocalTime(actual).toDateTimeToday();
DateTime lim = df.parseLocalTime(limit).toDateTimeToday().plusDays(1);

if (ac.isBefore(lim)) {
    System.out.println("Not yet at the limit");
}