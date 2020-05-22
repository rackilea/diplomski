class Time
{
    int hours,minutes,seconds;
    public Time(int hours,int minutes,int seconds)
    {
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
    }
    public int getHours()
    {
        return this.hours;
    }
    public int getMinutes()
    {
        return this.minutes;
    }
    public int getSeconds()
    {
        return this.seconds;
    }
    public String toString()
    {
        return String.format("%d:%02d:%02d %s",((hours==0||hours==12)?   12:hours%12),this.minutes,this.seconds,((hours>=12)?"PM":"AM"));
    }  
}
class TimeComparator implements Comparator<Time>
{
    public int compare(Time t1,Time t2)
    {
        int hours=t1.getHours()-t2.getHours();
        int minutes=t1.getMinutes()-t2.getMinutes();
        int seconds=t1.getSeconds()-t2.getSeconds();
        if(hours>0)
        return 1;
        else if(hours<0)
        return -1;
        if(minutes>0)
        return 1;
        else if(minutes<0)
        return -1;
        if(seconds>0)
        return 1;
        else if(seconds<0)
        return -1;
        return 0;
    }
    public boolean equals(Object obj)
    {
        return true;
    }
}