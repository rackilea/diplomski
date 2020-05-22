public static void main(String[] args) {
    DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault());
    TimeZone.setDefault(TimeZone.getDefault());
    SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat simpleTimeFormatter = new SimpleDateFormat("hh:mm:ss a");
    Date today = new Date();
    String localeFormattedInTime = dateFormatter.format(today);
    try {
        Date parsedDate = dateFormatter.parse(localeFormattedInTime);
        System.out.println("Locale:" + localeFormattedInTime);
        System.out.println("After parsing a date: " + parsedDate);

        simpleDateFormatter.setTimeZone(TimeZone.getDefault());
        simpleTimeFormatter.setTimeZone(TimeZone.getDefault());

        String date = simpleDateFormatter.format(today);
        String time = simpleTimeFormatter.format(today);
        System.out.println("Today's only date: " + date);
        System.out.println("Today's only time: " + time);

        //// Locale to UTC converting

        System.out.println("TimeZone.getDefault() >>> " + TimeZone.getDefault());

        simpleDateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleTimeFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        String utcDate = simpleDateFormatter.format(today);
        String utcTime = simpleTimeFormatter.format(today);
        System.out.println("Convert into UTC's date: " + utcDate);
        System.out.println("Convert into UTC's only time: " + utcTime);

        //// UTC to locale converting
        /**
         ** //////EDIT
        */
        // at this point your utcDate,utcTime are strings that are formated in UTC
        // so first you need to parse them back to Dates using UTC format not Locale
        Date getDate = simpleDateFormatter.parse(utcDate);
        Date getTime = simpleTimeFormatter.parse(utcTime);

        // NOW after having the Dates you can change the formatters timezone to your
        // local to format them into strings
        simpleDateFormatter.setTimeZone(TimeZone.getDefault());
        simpleTimeFormatter.setTimeZone(TimeZone.getDefault());

        String getLocalDate = simpleDateFormatter.format(getDate);
        String getLocalTime = simpleTimeFormatter.format(getTime);
        System.out.println("Get local date: " + getLocalDate);
        System.out.println("Get local time: " + getLocalTime);

    } catch (ParseException e) {
        e.printStackTrace();
    }

}