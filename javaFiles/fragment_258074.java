public JSONObject getRestRequest() { // 1 - your method is invoked by another method and control starts here
    final JSONObject res; // 2 - This final (i.e. immutable) field is created

    // 3 - You create a new request object - no networking is happening yet
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, this.restPath, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) { // basically I just want to return this response
            // 5 - Some time later, after the request completes, this method is invoked
            // BUT - you can't assign to res because it's final (immutable)
            res = response;
        }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
    );

    // 4 - IMMEDIATELY after creating "request", the value that was created in step 2 (which is null) is returned
    return res;
}