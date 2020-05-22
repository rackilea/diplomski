SimpleDateFormat  dt = new SimpleDateFormat("hh:mm"); 
     Date date=  dt.parse(str); // GET TIME HERE
    Calender cal=Calender.getInstance();
    cal.setTime(date);
    String hours=cal.get(Calendar.HOUR);
    String minutes=cal.get(Calendar.MINUTE);