public static void main(String[] args) {
    Date dateToFormat = null;

    DateFormat formatter = new SimpleDateFormat("E MMM d HH:mm:ss yyyy"); // zzzz yyyy");

    String databaseDateAsString = "Wed May 11 16:30:00 Asia/Calcutta 2011";
    databaseDateAsString = "Wed May 11 16:30:00 2011";
    formatter.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
    try {
        dateToFormat = formatter.parse(databaseDateAsString);
        System.out.println(dateToFormat);
    } catch(Exception e) {
        System.out.println("Cannot Parse Date:" + e);
    }
}