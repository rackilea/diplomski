public class MyJsonArrayRequest extends JsonArrayRequest {

    private Map<String, String> mPostParams;

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mPostParams;
    }

    public MyJsonArrayRequest(String url, Map<String, String> postParams, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);

        this.mPostParams = postParams; 
    }
}