public void runRequest() {
    StringRequest sr = new StringRequest("http://reju.pe.hu/test.php", new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            if (response.contains("1")) {
                //here comes the specific response
            } else {
                runRequest();
                //re run the request
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    });
    RequestQueue xx = Volley.newRequestQueue(this);
    xx.add(sr);
}