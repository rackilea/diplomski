public class ApplicationServiceRetry {

    SimpleRetryPolicy policy = new SimpleRetryPolicy(5,
            Collections.<Class<? extends Throwable>, Boolean> singletonMap(Exception.class, true));

    RetryTemplate template = new RetryTemplate();

    {
        template.setRetryPolicy(policy);
    }

}