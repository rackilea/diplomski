System.out.println(time);
    DateFormat df = new SimpleDateFormat("hh:mm:ss");
    Date preTime=df.parse(df.format(time));
    Date sysTime = df.parse(df.format(new Date()));
    System.out.println(sysTime);
    long diff=preTime.getTime()-sysTime.getTime();
    System.out.println(diff);