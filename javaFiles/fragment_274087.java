JSONObject parameters = new JSONObject();
 try {
      parameters.put("text" , "sample text");
      parameters.put("language", "en");
 } catch (JSONException e) {
      e.printStackTrace();
 }
 JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, stringurl, parameters,
     new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
           //TODO: handle success
        }
     }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                //TODO: handle failure
            }
      });

Volley.newRequestQueue(this).add(jsonRequest);