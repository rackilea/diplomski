public class Select_Collage extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_message);

        //SharedPreference to Store API Result
        pref = getApplicationContext().getSharedPreferences("CachedResponse", 0);

        //Somewhere on Signout button click, delete the login sharedpreference
        signOut();

    }

    private void signOut() {

        SharedPreferences.Editor editor = pref.edit();
        editor.remove("login");
        editor.apply();

        Intent intent = new Intent(Select_Collage.this, Login.class);
        startActivity(intent);
        finish();

    }
}