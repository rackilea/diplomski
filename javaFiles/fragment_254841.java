from("seda:backup")
.routePolicy(policy)
.errorHandler(
  defaultErrorHandler()
  .redeliveryDelay(1000L)
  .maximumRedeliveries(-1)
  .retryAttemptedLogLevel(LoggingLevel.ERROR)
).threads(2).to("jdbc:mydb");