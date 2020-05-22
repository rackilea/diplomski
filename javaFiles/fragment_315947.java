String myStringDate = "2012-05-03 @ 15.55.05.433Z";
       myStringDate = myStringDate.replace("@ ","");   //Also removes extra whitespace  

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
Date myDate = dateFormat.parse("your date string");
     myDate.getTime(); //Your timestamp in milliseconds