Timestamp ts; 
    //give some value to ts
    Time time ;
    //give some value to time

    //Calendar based on ts          
    Calendar cTs=Calendar.getInstance();
    cTs.setTimeInMillis(ts.getTime());

    //Calendar based on time
    Calendar cTime=Calendar.getInstance();
    cTime.setTimeInMillis(time.getTime());

    cTs.set(Calendar.HOUR_OF_DAY, cTime.get(Calendar.HOUR_OF_DAY));
    cTs.set(Calendar.MINUTE, cTime.get(Calendar.MINUTE));
    cTs.set(Calendar.SECOND, cTime.get(Calendar.SECOND));
    cTs.set(Calendar.MILLISECOND, cTime.get(Calendar.MILLISECOND));

    //set value of ts based on the modified cTs
    ts.setTime(cTs.getTimeInMillis());
    System.out.println(ts.getTime());