public class MediaImage {

String imageurl;
Context context;
ResponseCallback callback;

public Mediaimage(Context context, ResponseCallback callback) {
    this.context = context;
    this.callback=callback;
}

public void getimageurl(String id){


    String url="http://www.mytre.com/wp-json/wp/v2/media/"+id;

    RequestQueue requestqueue = Volley.newRequestQueue(context);
    StringRequest stringrequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                imageurl=response;
                JSONObject jsonObject = new JSONObject(response);
                String j = jsonObject.getString("guid");
                jsonObject = new JSONObject(j);
                imageurl =jsonObject.getString("rendered");
                callback.onImageResponse(imageurl);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
    requestqueue.add(stringrequest);
    }
   }