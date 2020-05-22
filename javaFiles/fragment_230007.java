Map<Long, String> map = new HashMap<>();
map.put(0L, "00:00");
map.put(1L, "00:00");  // would normally be 00:00:01
map.put(2L, "00:00");  // would normally be 00:00:02
map.put(60L, "00:01");
// and so on
map.put(3600L, "01:00:00");
map.put(3601L, "01:00:01");
// and so on to 86399
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
  .appendText(ChronoField.SECOND_OF_DAY, map)
  .toFormatter();