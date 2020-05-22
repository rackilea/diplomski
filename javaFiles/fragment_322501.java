StringRequest sr = new StringRequest(Request.Method.GET, "https://t3x9lg8utf.execute-api.us-east-2.amazonaws.com/prod?id="+Uri.encode(id)+"&username="+Uri.encode(username)+"&numero_passeport="+Uri.encode(numero_passeport)+"&decision="+Uri.encode(decision),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("HttpClient", "success! response: " + response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClient", "error: " + error.toString());
                    }
                })
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("id","\"\"");
                params.put("username","\"zaeae\"");
                params.put("numero_passeport","\"\"");
                params.put("decision","\"\"");

                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                return params;
            }
        };
        queue.add(sr);