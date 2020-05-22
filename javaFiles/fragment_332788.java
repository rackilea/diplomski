SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    SimpleDateFormat s2 = new SimpleDateFormat("ddMMyyyyHHmm");
    Date d = s1.parse("02/11/2012 23:11");
    String s3 = s2.format(d);
    System.out.println(s3);
    long l = Long.parseLong(s3);
    System.out.println(l);