/* (non-Javadoc)
 * @see com.android.volley.Request#getHeaders()
 */
@Override
public Map<String, String> getHeaders() throws AuthFailureError {
    Map<String, String> headers = super.getHeaders();

    if (headers == null || headers.equals(Collections.emptyMap())) {
        headers = new HashMap<String, String>();
    }

    headers.put("User-Agent", "Custom-Agent 1.0");
    // probably don't need to set the content-type here -- 
    // it should be set for you by Volley
    //headers.put("Content-Type", "application/json");

    return headers;
}