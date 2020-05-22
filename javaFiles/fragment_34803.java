public class MainActivity extends AppCompatActivity {

EditText editText;

public String entries="test";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editText = (EditText) findViewById(R.id.text);

    getData();
    System.out.println(entries); //here id null or in my case "test"
    setData();


}

public void getData(){
    Response.Listener<String> responseListenerCount = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d("JSON Parser", response);
            try {
                JSONObject jsonResponse = new JSONObject(response);
                int success = jsonResponse.getInt("success");
                if (success==1) {



                    entries = jsonResponse.getString("user_id"); //geting user id
                   System.out.println(entries);
                    Toast.makeText(getApplicationContext(), " Retrieving success ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), " Retrieving failed ", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            System.out.println(entries); //id is still there
            setData();
        }
    };
    CountRequest countRequest = new CountRequest(responseListenerCount);
    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
    queue.add(countRequest);
   System.out.println(entries); //here id null or in my case "test"
}

public void setData(){
    editText.setText(entries);
}}