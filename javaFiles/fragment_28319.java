public class MainActivity extends ActionBarActivity {


    //private SharedPreferences saveUserName;
    private AutoCompleteTextView editText1, editText2, editText3,
                                 editText4, editText5, editText6;
    private ImageButton imageButton1, imageButton2, imageButton3,
                        imageButton4, imageButton5, imageButton6;
    private final String PREFERENCES_NAME = "userinfo"; 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        getUserName();

        SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);  
        editText1.setText(preferences.getString("EditText1", null));
        editText2.setText(preferences.getString("EditText2", null));
        editText3.setText(preferences.getString("EditText3", null));
        editText4.setText(preferences.getString("EditText4", null)); 
        editText5.setText(preferences.getString("EditText5", null)); 
        editText6.setText(preferences.getString("EditText6", null)); 

onStop();

    }
    private void initializeViews(){
        editText1 = (AutoCompleteTextView) findViewById(R.id.UserName);
        editText2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        editText3 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView3);
        editText4 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView4);
        editText5 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView5);
        editText6 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView6);
    }

    public void onStop() {  
         super.onStop(); 
         SharedPreferences sharePreferences = getSharedPreferences("userName", 0);
         SharedPreferences.Editor editor = sharePreferences.edit();
         editor.putString("EditText1", editText1.getText().toString());
         editor.putString("EditText2", editText2.getText().toString());
         editor.putString("EditText3", editText3.getText().toString());
         editor.putString("EditText4", editText4.getText().toString());
         editor.putString("EditText5", editText5.getText().toString());
         editor.putString("EditText6", editText6.getText().toString());
         editor.commit();
    }

    public void  getUserName()
    {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);  
        editText1.setText(preferences.getString("EditText1", null));
        editText2.setText(preferences.getString("EditText2", null));
        editText3.setText(preferences.getString("EditText3", null));
        editText4.setText(preferences.getString("EditText4", null)); 
        editText5.setText(preferences.getString("EditText5", null)); 
        editText6.setText(preferences.getString("EditText6", null)); 
    }

    public void goToUserInfoActivity(View v)
    {
        Intent it = new Intent(this, UserInfoActivity.class);
        startActivity(it);
    }
}