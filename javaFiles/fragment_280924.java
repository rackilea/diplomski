public class DataFetcherTask extends RecursiveTask<List<DataResponse>> {

  private final DataRequest key;
  private final RestTemplate restTemplate;

  public DataFetcherTask(DataRequest key, RestTemplate restTemplate) {
      this.key = key;
      this.restTemplate = restTemplate;
  }

  @Override
  protected List<DataResponse> compute() {
    // Create subtasks for the key and invoke them
    List<DataRequestTask> requestTasks = requestTasks(generateKeys());
    invokeAll(requestTasks);

    // All tasks are finished if invokeAll() returns.
    List<DataResponse> responseList = new ArrayList<>(requestTasks.size());
    for (DataRequestTask task : requestTasks) {
      try {
        responseList.add(task.get());
      } catch (InterruptedException | ExecutionException e) {
        // TODO - Handle exception properly
        Thread.currentThread().interrupt();
        return Collections.emptyList();
      }
    }

    return responseList;
  }

  private List<DataRequestTask> requestTasks(List<DataRequest> keys) {
    List<DataRequestTask> tasks = new ArrayList<>(keys.size());
    for (DataRequest key : keys) {
      tasks.add(new DataRequestTask(key));
    }

    return tasks;
  }

  // In this method I am making a HTTP call to another service
  // and then I will make List<DataRequest> accordingly.
  private List<DataRequest> generateKeys() {
      List<DataRequest> keys = new ArrayList<>();
      // use key object which is passed in contructor to make HTTP call to another service
      // and then make List of DataRequest object and return keys.
      return keys;
  }

  /** Inner class for the subtasks. */
  private static class DataRequestTask extends RecursiveTask<DataResponse> {

    private final DataRequest request;

    public DataRequestTask(DataRequest request) {
      this.request = request;
    }

    @Override
    protected DataResponse compute() {
      return performDataRequest(this.request);
    }

    private DataResponse performDataRequest(DataRequest key) {
      // This will have all LogicA code here which is shown in my original design.
      // everything as it is same..
      return new DataResponse(DataErrorEnum.OK, DataStatusEnum.OK);
    }
  }

}