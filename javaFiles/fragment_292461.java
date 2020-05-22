public class FinalWorkActivity extends Activity {
    private String pref_file="pref.xml";
    EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (EditText) findViewById(R.id.editText1);
        SharedPreferences pref=getSharedPreferences(pref_file,Context.MODE_PRIVATE);
        Boolean val= pref.getBoolean("firstuse", true);
        if(val) {
        text.setText("first use");
        } else {
        text.setText("Not first use");
        }
    }
}