public interface TestServerMBean
{
    public long getUptimeMillis();
    public long getFooCount();
    public void setFooCount(long val);
    public void printStuff(String stuff);
}