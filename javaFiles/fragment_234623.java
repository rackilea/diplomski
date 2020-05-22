String dateString = "2015.12.10 13:58:18";

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
    Date date1 = sdf1.parse(dateString);

    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    sdf2.setTimeZone(TimeZone.getTimeZone("EST"));
    Date date2 = sdf2.parse(dateString);

    // Shows that the parsing honours time zone -- will print:
    // Thu Dec 10 14:58:18 CET 2015 (original date was parsed as GMT)
    // Thu Dec 10 19:58:18 CET 2015 (original date was parsed as EST)
    System.out.println(date1);
    System.out.println(date2);