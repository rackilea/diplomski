Time time=Time.valueOf("03:51:46");
    System.out.println(time);
    Time currentTime=Time.valueOf("03:25:12");
    System.out.println(currentTime);
    long diff=time.getTime()-currentTime.getTime();
    System.out.println(diff);