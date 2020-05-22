try {
    JSONObject error =new JSONObject(responseBody);
    JSONObject errorobj = error.getJSONObject("error");  // get error JSONObject
     // get  message from error JSONObject
    String message = errorobj.getString("message");
    Log.d("error", message);

} catch (JSONException e) {
      Log.e("JSON Parser", "Error :" + e.getMessage());
  }