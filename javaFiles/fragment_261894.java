import org.simpleframework.xml.Element;

public class RetryParameters {

    @Element(name = "min-backoff-seconds")
    private String minBackoffSeconds;
    @Element(name = "max-backoff-seconds")
    private String maxBackoffSeconds;
    @Element(name = "max-doublings")
    private String maxDoublings;
    @Element(name = "task-retry-limit")
    private String taskRetryLimit;

    public String getMinBackoffSeconds() {
        return minBackoffSeconds;
    }

    public String getMaxDoublings() {
        return maxDoublings;
    }

    public String getMaxBackoffSeconds() {
        return maxBackoffSeconds;
    }

    public String getTaskRetryLimit() {
        return taskRetryLimit;
    }
}