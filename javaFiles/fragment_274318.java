public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    public static String Filename= "LoginFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences(Filename,MODE_PRIVATE);
        String name = sp.getString("k1", "");
        if(!name.isEmpty()){
            Intent intent = new Intent(MainActivity.this, Welcome.class);
            startActivity(intent);
        }
    }

    public void open(View v) {
        Intent i = new Intent(MainActivity.this,Form.class);
        startActivity(i);
    }
}