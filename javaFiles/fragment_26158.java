String URL = "http://192.168.1.104/json.php";

   // make sure your class implements this
   public  interface ResponseListener {
      public gotResponse(JSONArray array);
   }

   // implementation of ResponseListener
   public gotResponse(JSONArray array) {
      // eventually do more with this data
      Toast.makeText(json.this, array.toString(),Toast.LENGTH_LONG).show();
   }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        ResponseListener listener = this;

        JsonArrayRequest request = new JsonArrayRequest( URL,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

               try {
                    listener.gotResponse(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(request);