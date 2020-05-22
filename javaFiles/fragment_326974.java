@Service
public class BulkService {

    @Autowired
    private RestHighLevelClient client;

    public String flush( AtomicReference<BulkRequest> bulkRequest) throws Exception {

        BulkResponse bulkResponse = client.bulk(bulkRequest.get(), RequestOptions.DEFAULT);

        if(bulkResponse.hasFailures()) {
            return bulkResponse.buildFailureMessage();
        }
        else {
            return "All operations in the bulk request proceeded successfully!";
        }
    }
}