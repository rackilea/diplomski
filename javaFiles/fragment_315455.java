executorService.shutdown();
System.out.println("shut down threads");
try {
    executorService.awaitTermination(60, TimeUnit.SECONDS);
} catch (InterruptedException ignored) {
}