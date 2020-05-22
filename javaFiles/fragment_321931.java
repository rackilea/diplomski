StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
    @Override
    public void onResponse(String s) {
        ///handle response from service
    }, new ErrorResponse() {
      @Override
      public void onErrorResponse(VolleyError volleyError) {
        //handle error response
      }
  }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
          Map<String, String> params = new HashMap<String, String>();
          //add params <key,value>
          return params;
      }

      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String,String> headers = Constants.getHeaders(context);
        // add headers <key,value>
        String credentials = USERNAME+":"+PASSWORD;
        String auth = "Basic "
                + Base64.encodeToString(credentials.getBytes(),
                Base64.NO_WRAP);
        headers.put("Authorization", auth);
        return headers;
      }
  };
 mQueue.add(request);