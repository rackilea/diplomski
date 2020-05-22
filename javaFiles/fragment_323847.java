ExecutorService executor = Executors.newFixedThreadPool(N);

ResultSet results = getWaitingTasksStmt.executeQuery();

while( results.next() ) {
    executor.submit(new RunnableInheritedClass(results) ) );
}

executor.shutdown();
executor.awaitTermination(10, TimeUnit.MINUTES);