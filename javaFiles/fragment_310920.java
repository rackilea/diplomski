public class MainActivity extends AppCompatActivity {

SharedPreferences mPrefs;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final EditText a1 = (EditText) findViewById(R.id.add1);
    final EditText a2 = (EditText) findViewById(R.id.add2);

       a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                        //Your codes
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //same for a2

    setTitle("Insulin Calculator");
    mPrefs=this.getSharedPreferences("settings", 0);
}