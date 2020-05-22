public void loadSpinnerDataMake()
{

    makesName = new ArrayList<String>();

    JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(URL1, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            try {
                JSONArray jsonArray = response;
                for (int x = 0; x < jsonArray.length(); x++) {
                    JSONObject obMake = jsonArray.getJSONObject(x);
                    String nMake = obMake.getString("make");
                    makesName.add(nMake);

                    adapterMake.clear();
                    adapterMake.addAll(makesName);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();

        }
    });

    RequestQueue requestQueue = Volley.newRequestQueue(getContext());

    requestQueue.add(jsonObjectRequest);

}