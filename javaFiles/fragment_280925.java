public class DataClient implements Client {

  private final RestTemplate restTemplate = new RestTemplate();
  // Replace the ExecutorService with a ForkJoinPool
  private final ForkJoinPool service = new ForkJoinPool(15);

  @Override
  public List<DataResponse> getSyncData(DataRequest key) {
      List<DataResponse> responsList = null;
      Future<List<DataResponse>> responseFuture = null;

      try {
          responseFuture = getAsyncData(key);
          responsList = responseFuture.get(key.getTimeout(), key.getTimeoutUnit());
      } catch (TimeoutException | ExecutionException | InterruptedException ex) {
          responsList = Collections.singletonList(new DataResponse(DataErrorEnum.CLIENT_TIMEOUT, DataStatusEnum.ERROR));
          responseFuture.cancel(true);
          // logging exception here
      }

      return responsList;
  }

  @Override
  public Future<List<DataResponse>> getAsyncData(DataRequest key) {
      DataFetcherTask task = new DataFetcherTask(key, this.restTemplate);
      return this.service.submit(task);
  }
}