public class Utf8JSONRequest extends JsonRequest<JSONArray> {
public Utf8JSONRequest(int method, String url, JSONArray requestJSON, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
    super(method, url, String.valueOf(requestJSON), listener, errorListener);
}

@Override
protected Response<JSONArray> parseNetworkResponse(NetworkResponse networkResponse) {
    try {
        String jsonString = new String(networkResponse.data, "UTF-8");
        return Response.success(new JSONArray(jsonString),
                HttpHeaderParser.parseCacheHeaders(networkResponse));
    } catch (UnsupportedEncodingException e) {
        return Response.error(new ParseError(e));
    } catch (JSONException je) {
        return Response.error(new ParseError(je));
    }
}