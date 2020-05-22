SimpleDateFormat df = new SimpleDateFormat("'mydate' yyyy-MM-dd HH:mm:ss");
try {
    df.parse("mydate 2014-04-01 12:30:00");
} catch (ParseException e) {
    e.printStackTrace();
}