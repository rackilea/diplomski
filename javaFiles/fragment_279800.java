import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import java.util.Collections;
import java.util.Date;

public class AWSCloudWatchBillingService { 

    public static void main(String[] args) {
        final String awsAccessKey = "<YOUR_AWS_ACCESS_KEY>";
        final String awsSecretKey = "<YOUR_AWS_SECRET_ACCESS_KEY>";

        final AmazonCloudWatchClient client = client(awsAccessKey, awsSecretKey);
        final GetMetricStatisticsRequest request = request(); 
        final GetMetricStatisticsResult result = result(client, request);
        printIt(result);   
    }

    private static AmazonCloudWatchClient client(final String awsAccessKey, final String awsSecretKey) {
        final AmazonCloudWatchClient client = new AmazonCloudWatchClient(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
        client.setEndpoint("http://monitoring.us-east-1.amazonaws.com/");
        return client;
    }

    private static GetMetricStatisticsRequest request() {
        final long twoWeeks = 1000 * 60 * 60 * 24 * 15;
        final int twelveHours = 60 * 60 * 12;
        return new GetMetricStatisticsRequest()
            .withStartTime(new Date(new Date().getTime() - twoWeeks))
            .withNamespace("AWS/Billing")
            .withPeriod(twelveHours)
            .withDimensions(new Dimension().withName("Currency").withValue("USD"))
            .withMetricName("EstimatedCharges")
            .withStatistics("Average", "Maximum")
            .withEndTime(new Date());
    }

    private static GetMetricStatisticsResult result(
            final AmazonCloudWatchClient client, final GetMetricStatisticsRequest request) {
         return client.getMetricStatistics(request);
    }

    private static void printIt(final GetMetricStatisticsResult result) {
        Collections.sort(result.getDatapoints(), (Datapoint dp1, Datapoint dp2) -> dp1.getTimestamp().compareTo(dp2.getTimestamp()));
        System.out.println("**************************************"); 
        System.out.println(result);
    }
}