private static long strDateToUnixTimestamp(String dt) {
    DateFormat formatter;
    Date date = null;
    long unixtime;
    formatter = new SimpleDateFormat("dd/MM/yy");
    try {
        date = formatter.parse(dt);
    } catch (ParseException ex) {

        ex.printStackTrace();
    }
    unixtime = date.getTime() / 1000L;
    return unixtime;
}