JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = new JSONObject();

    try{
        jsonObject.put("store",storeId);
        jsonObject.put("people", people);
        jsonObject.put("date",reserveDay);
        jsonObject.put("time", reserveTime);
        jsonArray.put(jsonObject);
        Log.i("jsonString", jsonObject.toString());


    }catch(Exception e){

    }

    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, domain + api, jsonObject,
            new Response.Listener<JSONObject>(){
                @Override
                public void onResponse(JSONObject response) {
                    Log.e("Response", response.toString());
                    try {
                        JSONArray arrData = response.getJSONArray("data");
                        parseData(arrData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error.Response", error.toString());
                    String json = null;
                    NetworkResponse response = error.networkResponse;
                    if(response != null && response.data != null){
                        switch(response.statusCode){
                            case 400:

                                json = new String(response.data);
                                System.out.println(json);
                                break;
                        }
                        //Additional cases
                    }
                }
            })
    {
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap<>();
            headers.put("Authorization", finalToken);
        Log.d("headers", headers.toString());
            return headers;
        }
    };

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(jsonObjectRequest);
}