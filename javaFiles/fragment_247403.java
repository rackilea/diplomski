public String serviceWithRetry() {
    RetryTemplate retryTemplate = new RetryTemplate();
    final SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(12);
    retryTemplate.setRetryPolicy(retryPolicy);
    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
    backOffPolicy.setInterval(100L);
    retryTemplate.setBackOffPolicy(backOffPolicy);
    retryTemplate.execute(new RetryCallback<Void, RuntimeException>() 
        return retryTemplate.execute(new RetryCallback<Void, RuntimeException>() {
        @Override
        public void doWithRetry(RetryContext context) {
            LOG.info("Retry of connection count: {}", context.getRetryCount());
            return //something with your connection logic
        }
    });
}