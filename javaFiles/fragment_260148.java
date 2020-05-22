GZipRequest stringRequest = new GZipRequest(Request.Method.GET, url, new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {

        textView.setText(response);

        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(response);

            String t1 = jsonObject.getString("id");

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });