public void submitTasks(Runnable... rs) {
    try (AutocloseableExecutorService executor = new AutocloseableExecutorService(
             Executors.newSingleThreadExecutor())) {
        for (Runnable r : rs) executor.submit();
    }
}