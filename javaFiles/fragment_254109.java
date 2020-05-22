public static void getImagesUrls(final Context context, final String url, final ICallback<ArrayList<String>> callback) {
    RequestQueue queue = Volley.newRequestQueue(context); //Note, improve this using singleton ¹
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("productImagesUrl");
                        ArrayList<String> urls = new ArrayList<String>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject item = jsonArray.getJSONObject(i);
                            urls.add(item.getString("item"));
                        }
                        callback.onSucess(urls); //returns the result
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callback.onError(e.toString(),0); //error with the json
                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();

            //When get a request error
            callback.onError(error.toString(),error.networkResponse.statusCode);
        }
    });

    queue.add(request);
}