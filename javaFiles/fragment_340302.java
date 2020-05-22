public class MainActivity extends AppCompatActivity {

EditText editText1;
public static final String MyPREFERENCES = "MyPrefs" ;
public static final String Name = "nameKey";
SharedPreferences sharedpreferences;
String name;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    editText1 = (EditText)findViewById(R.id.editText1);
    name = sharedpreferences.getString("nameKey", "USE_ANY_DEFAULT_NAME_HERE");
    editText1.setText(name);
}

public void saveName(View v){
    SharedPreferences.Editor editor = sharedpreferences.edit();
    String n = editText1.getText().toString();
    editor.putString(Name, n);
    editor.commit();
    Toast.makeText(MainActivity.this,"Hey, value you entered is saved", Toast.LENGTH_SHORT).show();
}