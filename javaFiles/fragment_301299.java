public class Monitor {
    private final static long INTERVAL = 30*1000;
    private int sysId;
    private Date startTime;
    private int count = 1;
    public Monitor( int sysId, Date startTime ){
        this.sysId = sysId;
        this.startTime = startTime;
    }
    public int getSysId(){ return sysId; }
    public Date getStartTime(){ return startTime; }
    public void reset( Date startTime ){
        this.startTime = startTime;
        count = 1;
    }
    public int getCount(){ return count; }
    public void incCount(){ count++; }
    public boolean inInterval( Date t ){
        return (t.getTime() - startTime.getTime()) < INTERVAL;
    }
}