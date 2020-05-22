public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request r = new request(Main2Activity.this);
                r.youFunctionForVolleyRequest();
            }
        });
    }

   class request{

       Context ctx;
       public request(Context mContext) {
           ctx = mContext;
       }

       public void youFunctionForVolleyRequest() {

        RequestQueue queue = Volley.newRequestQueue(ctx);

        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins=22.2913,113.947&destinations=WanChai&mode=driving&key=";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>()
        {

            @Override
            public void onResponse(JSONObject response) {
               // callback.onSuccess(response); // call call back function here
                System.out.println("success");
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //VolleyLog.d("Volley error json object ", "Error: " + error.getMessage());
                System.out.println("failed");
            }
        })

        {
            @Override
            public String getBodyContentType ()
            {
                return "application/json";
            }
        };
        // Adding request to request queue
        queue.add(jsonObjReq);
    }

   }
}