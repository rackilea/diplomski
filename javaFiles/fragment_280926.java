public class DataClientCF {

  private final RestTemplate restTemplate = new RestTemplate();
  private final ExecutorService executor = Executors.newFixedThreadPool(15);

  public List<DataResponse> getData(DataRequest initialKey) {
    return CompletableFuture.supplyAsync(() -> generateKeys(initialKey), this.executor)
      .thenApply(requests -> requests.stream().map(this::supplyRequestAsync).collect(Collectors.toList()))
      .thenApply(responseFutures -> responseFutures.stream().map(future -> future.join()).collect(Collectors.toList()))
      .exceptionally(t -> { throw new RuntimeException(t); })
      .join();
  }

  private List<DataRequest> generateKeys(DataRequest key) {
    return new ArrayList<>();
  }

  private CompletableFuture<DataResponse> supplyRequestAsync(DataRequest key) {
    return CompletableFuture.supplyAsync(() -> new DataResponse(DataErrorEnum.OK, DataStatusEnum.OK), this.executor);
  }
}