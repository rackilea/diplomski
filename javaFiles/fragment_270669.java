class Sleep implements ParallelUtil.Task<Integer> {
  @Override
  public void execute(Integer data) throws Exception {
    Thread.sleep(Long.MAX_VALUE);
  }
}

class InterruptInvokeAll {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    executorService.submit(
        () -> {
          ParallelUtil<Integer> parallelUtil = new ParallelUtil<>();
          parallelUtil.execute(new Sleep(), Arrays.asList(1));
        });

    executorService.shutdownNow(); // indirectly interrupts thread that calls executor.invokeAll
   }    
}