String date="Sat, 11 Apr 2015 17:48:17 +0430";
    DateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
    Date startDate;
    try {
        startDate = df.parse(date);
        String newDateString = df.format(startDate);
        System.out.println(newDateString);
    } catch (ParseException e) {
        e.printStackTrace();
    }