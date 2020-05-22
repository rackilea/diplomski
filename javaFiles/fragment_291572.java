public class AbstractRoutingDataSourceMyDB extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return getDbConnectionMyDB();
    }

    // ThreadLocal variable so that the connection gets set for the current thread
    // using spring's request scope on the class instead of ThreadLocal would also work here.
    private final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public void setDbConnectionMyDB(String myKey) {
        Assert.notNull(myKey, "myKey cannot be null");

        contextHolder.set(myKey);

        String k = contextHolder.get();
    }

    public String getDbConnectionMyDB() {
        return (String) contextHolder.get();
    }

    public void clearDbConnectionMyDB() {
        contextHolder.remove();
    }
}