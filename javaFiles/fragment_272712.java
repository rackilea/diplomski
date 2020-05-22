DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
Date result;
try {
    result = df.parse("2013-03-13T20:59:31+0000");
    System.out.println("date:"+result); //prints date in current locale
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    System.out.println(sdf.format(result)); //prints date in the format sdf
}