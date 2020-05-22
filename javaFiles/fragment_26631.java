@Component
public class SampleAsyncService {
private RestTemplate restTemplate;
private AsyncRestTemplate asyncRestTemplate;

@Value("${myapp.batchSize:1000}")
private int batchSize;

public SampleAsyncService(AsyncRestTemplate asyncRestTemplate, RestTemplate restTemplate) {
    this.asyncRestTemplate = asyncRestTemplate;
    this.restTemplate = restTemplate;
}

public List<Record> callForRecords() {
    ResponseEntity<Integer> response = restTemplate.getForEntity("http://localhost:8081/countService",
            Integer.class);
    int totalRecords = response.getBody().intValue();
    List<Future<ResponseEntity<List<Record>>>> futures = new ArrayList<Future<ResponseEntity<List<Record>>>>();
    for (int offset = 0; offset < totalRecords;) {
        ListenableFuture<ResponseEntity<List<Record>>> future = asyncRestTemplate.exchange(
                "http://localhost:8081/records?startRow={}&endRow={}", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Record>>() {
                }, offset, batchSize);
        future.addCallback(
                new ListenableFutureCallback<ResponseEntity<ChatTranscript>>() {  
                    @Override  
                    public void onSuccess(ResponseEntity<ChatTranscript> response) {  
                        fullListOfRecords.addAll(responseEntity.getBody());
                        log.debug("Success: " + Thread.currentThread());  
                    }  

                    @Override  
                    public void onFailure(Throwable t) {
                        log.debug("Error: " + Thread.currentThread());
                    }  
                }
            );
        futures.add(future);
        offset = offset + batchSize;
    }

    int responses = 0;
    List<Record> fullListOfRecords = new ArrayList<Record>();
    while (responses < futures.size()) {
        for (Future<ResponseEntity<List<Record>>> future : futures) {
            if (future.isDone()) {
                responses++;
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    return fullListOfRecords;
}

public class Record {
}