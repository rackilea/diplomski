// First, parse the times
DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm");
LocalTime startTime = LocalTime.parse(c.getString("timestart"), f);
LocalTime endTime = LocalTime.parse(c.getString("timeend"), f);

// Then check if now is between those two times
LocalTime now = LocalTime.now();
if (now.isAfter(startTime) && now.isBefore(endTime)) {
    ...
}