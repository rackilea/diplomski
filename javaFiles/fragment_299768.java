executorService.shutdown();
try {
  //Add your timeout limit if you want
  executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
} catch (InterruptedException e) {
  ...
}