StringRequest stringRequest = new StringRequest(Request.Method.GET, "URL to fetch",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       //This is executed after successful response to URL
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //If error occurs
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Authorization", "Add a header to request");

                return params;
            }
        };

        NetworkSingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);