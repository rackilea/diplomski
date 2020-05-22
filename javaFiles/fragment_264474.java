public class MainActivity extends Activity {
      TextView tv; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView1);

RequestQueue queue = MyVolley.getRequestQueue(this);
        StringRequest myReq = new StringRequest(Method.GET, 
                                                "http://www.google.com/",
                                                createMyReqSuccessListener(),
                                                createMyReqErrorListener());

        queue.add(myReq);


    }