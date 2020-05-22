public class MainActivity extends AppCompatActivity {
    private final String TAG="ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if("refresh".equals(TestApplication.getStringToSet())){
            Toast.makeText(this,"From Background",Toast.LENGTH_SHORT).show();
            (TextView)findViewById(R.id.YOUR_TEXT_VIEW).setText("refresh")
        }else{
            Log.d(TAG,TestApplication.getStringToSet());
            Toast.makeText(this,"Not from background",Toast.LENGTH_SHORT).show();
           (TextView)findViewById(R.id.YOUR_TEXT_VIEW).setText("new_instance")
        }

    }
}
     //Implement other life cycle methods
}