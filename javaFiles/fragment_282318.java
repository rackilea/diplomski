String s="2014/03/31 14:52";
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");

    Date date = sdf.parse(s) ;// given date
    Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
    calendar.setTime(date);   // assigns calendar to given date 
    int hrs=    calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format

    int min=calendar.get(Calendar.MINUTE);

    System.out.println("hrs-->"+hrs);
    System.out.println("min-->"+min);

    if(hrs>=13 && min>0){
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 00);
        Date newDate=calendar.getTime();
        String newDateS=sdf.format(newDate);
        System.out.println(newDateS);
    }