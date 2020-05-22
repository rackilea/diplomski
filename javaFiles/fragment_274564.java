String str_date  = "Sun Jan 08 02:25:00 IST 2012";
    SimpleDateFormat fmt = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
    Date today = null;
    try {
        today = (Date)fmt.parse(str_date);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  

    java.sql.Date dt = new java.sql.Date(today.getTime());
    System.out.println(dt.toString());