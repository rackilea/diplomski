public static void main(String[] args) throws ParseException {
    TimeZone tz = TimeZone.getTimeZone("UTC");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SXXX");

    df.setTimeZone(tz);
    df2.setTimeZone(tz);

    long date;
    String dateToParse = "2016-05-25T22:00:10.6Z";
    try {
        date = df.parse(dateToParse).getTime() + 1;
    }catch (ParseException e){
        System.out.println("exception");
        date = df2.parse(dateToParse).getTime() + 1;

    }
    System.out.println(df.format(date));
}