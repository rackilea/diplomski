final String time = "23:15";

try {
    final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
    final Date dateObj = sdf.parse(time);
    System.out.println(dateObj);
    System.out.println(new SimpleDateFormat("K:mm").format(dateObj));
} catch (final ParseException e) {
    e.printStackTrace();
}