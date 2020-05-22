SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    String dateInString = "2014-05-26T00:00:00Z";

    try {

        Date utilDate = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
        System.out.println(utilDate);

    } catch (ParseException e) {

    }