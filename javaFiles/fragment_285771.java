try {
    ExecutorService es = Executors.newCachedThreadPool();
    List<QuittableTask> tasks = IntStream.range(1, COUNT).mapToObj(QuittableTask::new).peek(es::execute)
            .collect(Collectors.toList());
    Thread.currentThread().sleep(1000);
    tasks.forEach(QuittableTask::quit);
    es.shutdown();
} catch (Throwable e) {
    System.out.println("Error" + e.getMessage());
    e.printStackTrace();
    System.exit(0);
}