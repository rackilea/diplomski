private void getInfoJson(final String lati, final String longi) {
    StringRequest stringRequest = new StringRequest(Request.Method.GET,
            URL_DATA,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {                        
                    try {
                        JSONArray array = new JSONArray(s);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject o = array.getJSONObject(i);
                            //Getting lat and long from JSONObject
                            mLat = o.getString("lat");
                            mLong = o.getString("long");
                            if(lati.equals(mLat) && longi.equals(mLong)) 
                            {
                               //get name here
                               name = o.getString("name");
                            }else {

                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Toast.makeText(getContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
        }
    });
    RequestQueue requestQueue = Volley.newRequestQueue(getContext());
    requestQueue.add(stringRequest);
}