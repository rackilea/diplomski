Calendar cal = Calendar.getInstance();
    cal.setTime(alreadyParsedDateTime);
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    sdf3.setTimeZone(TimeZone.getTimeZone("UTC"));

    // Prints: 2015-12-23T23:00:00 for your example date string
    System.out.println(sdf3.format(cal.getTime()));