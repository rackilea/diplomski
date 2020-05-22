JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONObject jsonObject = response.getJSONObject("address");
                        String a = jsonObject.getString("extkey_next_receiving_address");

                     MainActivity.myValue=a;
                        Log.i("test", "onResponse: " + MainActivity.myValue);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i("test2", "onErrorResponse: error");
        }
    });
    mQueue.add(request);
}