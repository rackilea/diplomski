@Singleton
@Startup
public class MonitorBean {

    @Schedule(hour = "*", minute = "*/2", second = "0", persistent = false)
    public void searchErrorInLog() {
        // Read the log file
        // Looking for some error string
        // If found, send mail
    }

}