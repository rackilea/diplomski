public interface OnJSONResponseCallback {
    public void onJSONResponse(boolean success, JSONObject response);
}

public JSONObject getJSONObj(OnJSONResponseCallback callback) {
    ...
   @Override
   public void onSuccess(int i, Header[] headers, String response) {
       try {
           jObj = new JSONObject(response);
           callback.onJSONResponse(true, jObj);
       } catch (JSONException e) {
           Log.e("Exception", "JSONException " + e.toString());
       }
   }

   @Override
   public void onFailure(int statusCode, Header[] headers, String response, Throwable e) {
       try {
           jObj = new JSONObject(response);
           callback.onJSONResponse(false, jObj);
       } catch (JSONException e) {
           Log.e("Exception", "JSONException " + e.toString());
       }
   }
}