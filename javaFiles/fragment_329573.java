StringRequest stringRequest = new StringRequest("http://www.baidu.com",
    new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d("TAG", response);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("TAG", error.getMessage(), error);
        }
    });