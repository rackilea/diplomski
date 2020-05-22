public class MainActivity extends AppCompatActivity {

private static final String TAG = MainActivity.class.getName();

private Button btnSendRequest;


private RequestQueue mRequestQueue;

//creating a string request
private StringRequest stringRequest;
private String url = "http://9.xxx.xxx.xxx/test/xxxxxxx.aspx";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnSendRequest = (Button) findViewById(R.id.loginBtn);

    btnSendRequest.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //on click of the button send request and print the response

            //initializing request queue and string request in sendRequestAndPrintResponse
            sendRequestAndPrintResponse();
        }
    });
}

private void sendRequestAndPrintResponse() {
    mRequestQueue = Volley.newRequestQueue(this);
    stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.i(TAG, "Success" + response.toString());
            String result = response.toString();
            TextView displayText = (TextView) findViewById(R.id.displayText);
            displayText.setText(result);

            if (result.equalsIgnoreCase("{\"message\":\"success\",\"status\":\"Auth_Successful\",\"response\":\"Authentication successful\"}")){
                Toast.makeText(getApplicationContext(), "comparison successful", Toast.LENGTH_LONG).show();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i(TAG, error.toString());
        }
    }){
        @Override
        protected Map<String, String> getParams()
        {
            Map<String, String>  params = new HashMap<String, String>();
            params.put("username", "someone@example.com");
            params.put("password", "myPassword");
            return params;
        }
    };
    mRequestQueue.add(stringRequest);
  }
}