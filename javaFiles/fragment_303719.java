public class MainActivity extends Activity {

    GlobalVars myVars;      
    TextView myText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myVars = ((GlobalVars)getApplication());
        myText = (TextView) findViewById(R.id.myText);
        myText.setText(myVars.getMyString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}