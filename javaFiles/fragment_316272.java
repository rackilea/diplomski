import org.elasticsearch.client.RequestOptions;

...

public boolean checkTempConnection(RestHighLevelClient client) {
    try {
        return client.ping(RequestOptions.DEFAULT);
    } catch (Exception e) {
        log.warn("Can't get status : {}", e.getMessage());
        return false; // Not available
    }
}