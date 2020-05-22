DateFormat originalFormat = new SimpleDateFormat("mm-dd-yyyy", Locale.ENGLISH);
    DateFormat targetFormat = new SimpleDateFormat("yyyy-mm-dd");
    Date date = originalFormat.parse("01-21-2013");
    String formattedDate = targetFormat.format(date); 
    java.util.Date dtt = targetFormat.parse(formattedDate);
    java.sql.Date ds = new java.sql.Date(dtt.getTime());
    System.out.println(ds);
    System.out.println(dtt);
    System.out.println(formattedDate);