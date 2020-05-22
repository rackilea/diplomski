Response.Listener<JSONObject> myListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            textView.setText("Success: "+ response.toString());
        }
    };

    Response.ErrorListener myErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            textView.setText(String.valueOf(error.networkResponse.statusCode));
        }
    };

    // Request a string response from the provided URL.
    JsonObjectRequest  postRequest = new JsonObjectRequest(Request.Method.POST, url, postparams,
            myListener, myErrorListener);