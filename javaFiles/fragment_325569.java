SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
simpleRetryPolicy.setMaxAttempts(maxAttempts);

FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
fixedBackOffPolicy.setBackOffPeriod(backOffPeriod);

RetryTemplate retryTemplate = new RetryTemplate();
retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
retryTemplate.setRetryPolicy(simpleRetryPolicy);