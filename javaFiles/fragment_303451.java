RequestQueue mQueue =  Volley.newRequestQueue(UserProfile.this);
    //Json perse function
    String url = "xxxxxxxxxxxxxxxxxx";

    Map<String, String> params = new HashMap<String, String>();
    params.put("name", "mark");
    params.put("nam", "someOtherVal");

    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String requestResponse) {
            JSONArray response
            try {
             array=new JSONArray(requestResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
            for (int i = 0; i < response.length(); i++){
                try {
                    JSONObject jresponse = response.getJSONObject(i);
                    String name= jresponse.getInt("name");
                    String age= jresponse.getString("age");


                    AddDatatotable(name,age);
                    if(i == response.length() -1){

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    }){
@Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
};

    mQueue.add(request);