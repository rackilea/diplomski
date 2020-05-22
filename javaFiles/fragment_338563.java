Map<String, String> params = new HashMap<>();
params.put("ID", id);
params.put("USER_ID", userId);
MyJsonArrayRequest jsonArrayRequest = new MyJsonArrayRequest(GET_JSON_DATA_HTTP_URL, params,

    new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {

            progressBar.setVisibility(View.GONE);


            JSON_PARSE_DATA_AFTER_WEBCALL(response);
        }
    },
    new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });