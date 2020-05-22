public class EventsResponse<K> extends ApiResponse {
    public K response;
    public EventsResponse(Boolean success, RequestHandle requesthandle, K responsefromapi) {
        super(success, requesthandle);
        response = responsefromapi;
    }
}