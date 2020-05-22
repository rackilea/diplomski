public class BackgroundTask {
    Context context;
    ArrayList<Info> arrayList;
    Listener mListener; // listener to retrieve data
    String json_url = "http://cc97cf60.ngrok.io/api/note/";

    public BackgroundTask(Context context, Listener listener) {
        this.context = context;
        mListener = listener;
    }

    public void getArrayList() { // no return needed

        arrayList = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, json_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray;
                        try {
                            jsonArray = response.getJSONArray("objects");
                            int i;
                            for (i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                /*     Uri b = Uri.parse(jsonObject.getString("image")); //Type casting string to uri*/
                                String a = jsonObject.getString("title");
                                String b = jsonObject.getString("body");
                                Info info = new Info(a, b);
                                arrayList.add(info);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // if listener has been set, send data
                        if (mListener != null) {
                            mListener.onDataReceived(arrayList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // if listener has been set, send error
                if (mListener != null) {
                    mListener.onError(error.networkResponse.statusCode);
                }
            }
        });
        Singleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}