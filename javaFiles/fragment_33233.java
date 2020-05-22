JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                                Request.Method.POST,
                                url,
                                jsonRequest,
                                new JSONResponseListener(this),
                                new JSONResponseErrorListener(this)){
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            return headers;
        }

        @Override
        protected Map<String, String> getParams()  {
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            params.put("password", password);

            return params;
        }
    };
    MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);