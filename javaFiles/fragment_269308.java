RequestParams params = new RequestParams();
params.put("key", "value");
params.put("more", "data");
AsyncHttpClient client = new AsyncHttpClient();
client.post(url, params, responseHandler);

//do something with response
@Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

        }
    });