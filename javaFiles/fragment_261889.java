// Get the values from the edit texts
 final String email = editTextEmail.getText().toString().trim();
 final String password = editTextPassword.getText().toString().trim();

 Map<String, Object> params = new ArrayMap<>(2);
 // Adding parameters to request
 params.put(Config.KEY_EMAIL, email);
 params.put(Config.KEY_PASSWORD, password);

    // Creating a JSON Object request
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
            new Response.Listener<JSONObject>()
            {
             @Override
             public void onResponse(JSONObject response)
             {
              Log.d(TAG, response.toString());
              // other stuff ...
             }
            },
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error) 
                {
                    // You can handle the error here if you want
                }
            }); 

    // Adding the string request to the queue
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(jsonObjectRequest);