java.text.DateFormat outputFormat1 =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    Date d1 = outputFormat1.parse("2015-07-31 12:19:55");//start date
    Date d2 = outputFormat1.parse("2015-07-31 13:38:20");//end date
    long diff = d2.getTime() - d1.getTime();
    long diffHours = diff / (60 * 60 * 1000) % 24;//in terms of hours
    long diffmin = diff / (60 * 1000) % 60;//in mimutes
    long diffsec = diff / (1000) % 60;//in seconds
    String rtime=diffHours+"h:"+diffmin+"m:"+diffsec+"s";
    System.out.println(rtime);//1h:18m:25s