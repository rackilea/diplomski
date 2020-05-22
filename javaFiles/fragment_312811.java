private void insertToDb() throws  JSONException{
        //createJsonArray();
        final String jsonArray = itemSelectedJson.toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, INVEST_URL,


           new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    display.setText("This is the "+response);
                    Toast.makeText(AddInvEst.this, "This is the response"+response, Toast.LENGTH_LONG).show();
                    Log.d("RESPONSE", response.toString().trim());
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {

            Map<String,String> params = new HashMap<>();
            params.put(KEY_JSONARRAY,jsonArray);
            return params;
        }
    };

    RequestQueue requestQ =Volley.newRequestQueue(this);
    requestQ.add(stringRequest);

}