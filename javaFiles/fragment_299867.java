QueuedThreadPool queuedThreadpool= new QueuedThreadPool(5);
queuedThreadpool.setMinThreads(2);
queuedThreadpool.setName("HttpClient");

httpClient.setExecutor(queuedThreadpool);
httpClient.start();