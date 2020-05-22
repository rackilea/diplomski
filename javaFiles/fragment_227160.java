Calendar c=Calendar.getInstance();
    c.setTimeInMillis(time.getTime());
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);

    ts.setTime(c.getTimeInMillis());
    System.out.println(ts.getTime());