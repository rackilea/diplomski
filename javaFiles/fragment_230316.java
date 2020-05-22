ExecutorService service = Executors.newSingleThreadScheduledExecutor();

\\ use the service to do work
\\ to shutdown the service
service.shutdown();

\\ to wait till the service terminate
service.awaitTermination();