String[] times = {"08:00", "09:15", "09:45", "08:15", "08:45", "09:30"};
    String first[]=null;
    String second[]=null;
    for(int i=0;i<times.length-1;i++)
    {
        Date date=new SimpleDateFormat("hh:mm").parse(times[i]);
        Date date2=new SimpleDateFormat("hh:mm").parse(times[i+1]);
        if(date.getTime()>date2.getTime())
        {
            first=Arrays.copyOfRange(times, 0, i+1);
            second=Arrays.copyOfRange(times, (i+1), (times.length));
        }
    }