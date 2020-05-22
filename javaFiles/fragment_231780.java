public class HealthChecker
{
    public final long THRESHOLD = 10000L; // 10 seconds

    private final Map <Thread, Long> lastFineReports =
        new ConcurrentHashMap <Thread, Long> ();

    /**
     * Each thread should call this method periodically.
     */
    public void iAmFine ()
    {
        lastFineReports.put (
            Thread.currentThread (), 
            Long.valueOf (System.currentTimeMillis ()));
    }

    /**
     * Used by whatchdog to know whether everything is OK.
     */
    public boolean isEverythingOK ()
    {
        Long [] timestamps = 
            lastFineReports.
                values ().
                    toArray (new Long [lastFineReports.size ()]);

        long now = System.currentTimeMillis ();
        for (Long t: timestamps)
            if (now - t.longValue () > THRESHOLD)
                return false;

        return true;
    }
}