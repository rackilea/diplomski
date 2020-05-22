String url = "http://anc.php";
    JSONObject jsonObject = new JSONObject();
    try {
        jsonObject.put("product", "magie");
    } catch (JSONException e) {
        e.printStackTrace();
    }

    final HashMap<String,String> hashMap2 = new HashMap<>();
    hashMap2.put("json",jsonObject.toString());

    StringRequest strReq = new StringRequest(Request.Method.POST,
            url, new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {
            Log.e("order_list", response);
            GlobalAlerts.hideProgressDialog();
        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Error", "Error: " + error.getMessage());
            GlobalAlerts.hideProgressDialog();
        }
    }) {
        @Override
        protected Map<String, String> getParams() {
            /*Map<String,String> params = new HashMap<>();
            params.put("employee_id"," 1");*/
            return hashMap2;
        }
    };
    Application.getInstance().addToRequestQueue(strReq, "order_list");