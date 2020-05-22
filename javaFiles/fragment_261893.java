import org.simpleframework.xml.Element;

public class Queue {

    @Element
    private String rate;
    @Element
    private String name;
    @Element(name = "retry-parameters")
    private RetryParameters retryParameters;

    public String getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public RetryParameters getRetryParameters() {
        return retryParameters;
    }
}