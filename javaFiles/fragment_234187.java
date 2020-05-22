public class MyApiClient {
    private static final String BASE_URL = "http://example.com/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void getQuestions(long docId, AsyncHttpResponseHandler responseHandler) {
        get("docs/" + String.valueOf(docId) + "/questions" , null, responseHandler);
    }

    public static void getAnswers(long docId, AsyncHttpResponseHandler responseHandler){
        get("docs/" + String.valueOf(docId) + "/answers" , null, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}