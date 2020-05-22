DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMddHHmmss");
DateTime now = DateTime.now();
DateTime other1 = dtf.parseDateTime("20160418184137");
DateTime other2 = dtf.parseDateTime("20160418180000");

DateTime sharpHour = now.hourOfDay().roundFloorCopy();

if (!sharpHour.isEqual(other1.minuteOfDay().roundFloorCopy())) {
    System.out.println("Not matching sharp hour: " + other1);
}
DateTime other2Floor = other2.minuteOfDay().roundFloorCopy();
if (sharpHour.isEqual(other2Floor)) {
    System.out.println("Matching sharp hour: " + other2);
}