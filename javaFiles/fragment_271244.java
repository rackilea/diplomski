String actual = "18:01:23";
String limit = "00:16:23";

String[] parts = actual.split(":");
Calendar cal1 = Calendar.getInstance();
cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
cal1.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
cal1.set(Calendar.SECOND, Integer.parseInt(parts[2]));

parts = limit.split(":");
Calendar cal2 = Calendar.getInstance();
cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
cal2.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
cal2.set(Calendar.SECOND, Integer.parseInt(parts[2]));

// Add 1 day because you mean 00:16:23 the next day
cal2.add(Calendar.DATE, 1);

if (cal1.before(cal2)) {
    System.out.println("Not yet at the limit");
}