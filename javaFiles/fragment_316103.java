Calendar startDateTime=Calendar.getInstance();
    startDateTime.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
    startDateTime.set(Calendar.HOUR_OF_DAY,1);
    startDateTime.set(Calendar.MINUTE,0);
    startDateTime.set(Calendar.SECOND,0);

    System.out.println("start Date : "+startDateTime.getTime());
    Calendar endDateTime=Calendar.getInstance();
    endDateTime.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
    endDateTime.set(Calendar.HOUR_OF_DAY,17);
    endDateTime.set(Calendar.MINUTE,0);
    endDateTime.set(Calendar.SECOND,0);

    System.out.println("end Date : "+endDateTime.getTime());

   Calendar today = Calendar.getInstance();

   if(today.after(startDateTime) && today.before(endDateTime))
   {
       System.out.println("Yes");
   }