public void getRestRequest(final Callback<JSONObject> callback) { // 1 - your method is invoked by another method and control starts here
    // Now you're passing in a callback that will be invoked later with the result
    // final JSONObject res; // 2 - You no longer need this local variable

    // 3 - You create a new request object - no networking is happening yet
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, this.restPath, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) { // basically I just want to return this response
            // 5 - Some time later, after the request completes, this method is invoked
            // This time, you invoke your callback with the result
            callback.onSuccess(response)
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                // 6 - You can also pass back errors to your callback
                callback.onError(error);
            }
        }
    );

    // 4 - You return IMMEDIATELY after creating "request"
}