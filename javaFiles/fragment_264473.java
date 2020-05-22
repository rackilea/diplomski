public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = MyVolley.getRequestQueue();
        StringRequest myReq = new StringRequest(Method.GET, 
                                                "http://www.google.com/",
                                                createMyReqSuccessListener(),
                                                createMyReqErrorListener());

        queue.add(myReq);

    }

    TextView tv = (TextView) findViewById(R.id.textView1);