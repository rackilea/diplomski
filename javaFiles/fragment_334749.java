private static final String COUNTER_BATCHMANAGER_SENT_REQUESTS = "batchmanager.sent.requests";
private static final String METHOD_TAG = "method";
private static final String PATH_TAG = "path";
private final Counter requestCounter;
...
requestCounter = Counter.builder(COUNTER_BATCHMANAGER_SENT_REQUESTS)
    .description("Total number of rest requests sent")
    .tags(METHOD_TAG, "", PATH_TAG, "")
    .register(meterRegistry);
...
 Metrics.counter(COUNTER_BATCHMANAGER_SENT_REQUESTS, METHOD_TAG, methodName, PATH_TAG, path)
    .increment();