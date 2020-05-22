DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
try {
    Date dateToString = dateFormat.parse("Thu Jan 01 13:00:00 CST 2015");
    System.out.println(dateFormat.format(dateToString));
} catch (ParseException e) {
    e.printStackTrace();
}