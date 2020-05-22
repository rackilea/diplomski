Date date1 = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(date1);
    c.add(Calendar.MINUTE, 5); //adds five minute to the calendar's date
    System.out.println(date1.getTime()); //current time
    System.out.println(c.getTime().getTime()); //current time + 5 minutes