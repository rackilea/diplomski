String time = "22:00-01:05";
String[] parts = time.split("-");

LocalTime start = LocalTime.parse(parts[0]);
LocalTime end = LocalTime.parse(parts[1]);
if (start.isBefore(end)) { // normal case
    System.out.println(Duration.between(start, end));
} else { // 24 - duration between end and start, note how end and start switched places
    System.out.println(Duration.ofHours(24).minus(Duration.between(end, start)));
}