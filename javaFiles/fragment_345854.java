SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    try {
        Date dateInUTC = dateFormat.parse("2011-10-16 00:00:00");
        Date currentDate = new Date();
        String stringInUTC = dateFormat.format(currentDate);
        System.out.println(dateInUTC);
        System.out.println(currentDate);
        System.out.println(stringInUTC);
    }
    catch (ParseException e) {
        // not too worry, I wrote a nice date
    }