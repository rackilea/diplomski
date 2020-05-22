Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");//2018-02-05T18:00:51.001+0000
    String text = dateFormat.format(date);

    try {
        Date test = dateFormat.parse(text);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }