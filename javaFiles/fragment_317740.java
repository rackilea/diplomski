BigQuery bigquery = BigQueryOptions.getDefaultInstance()
     .setRetrySettings(RetrySettings.newBuilder()
     .setMaxAttempts(10)
     .setRetryDelayMultiplier(1.5)
     .setTotalTimeout(Duration.ofMinutes(5))
.build()).getService();