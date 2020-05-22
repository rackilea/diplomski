SimpleDateFormat df = new SimpleDateFormat("'mydate' yyyy-MM-dd HH:mm:ss");
    try {
        df.parse("mydates 2014-04-01 12:30:00"); //check the additional s
    } catch (ParseException e) {
        e.printStackTrace();
    }