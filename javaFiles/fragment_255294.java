public class VolleyWebService {

public interface VolleyResponseListener {
  void onSuccess(JSONObject response);
  void onError(VolleyError error);
}

public JSONObject result;

public JSONObject getResponse(String url, Context mContext, VolleyResponseListener listener) {
    RequestQueue mQueue = Volley.newRequestQueue(mContext);
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            Log.e(TAG, "Anshuman" + response.toString());

            listener.onSuccess(response);
        }
    },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                   listener.onError(error);
                }
            });

    mQueue.add(request);
   return result;
}
}