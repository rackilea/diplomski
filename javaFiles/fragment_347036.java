try {
    String s = "2012-06-20 18:09:38";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //df.setTimeZone(TimeZone.getTimeZone("EDT"));
    df.setTimeZone(TimeZone.getTimeZone("GMT-04:00"));
    Date timestamp = null;

    timestamp = df.parse(s);
    df.setTimeZone(TimeZone.getTimeZone("GMT+05:00"));
    System.out.println("Old = " + s);
    String parsed = df.format(timestamp);
    System.out.println("New = " + parsed);

    } catch (Exception e) {
    e.printStackTrace();
}