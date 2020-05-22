public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        //SharedPreference to Store API Result
        pref = getApplicationContext().getSharedPreferences("CachedResponse", 0);

        Login();

    }

    private void login() {

        //If login is successfull, before moving to next activity, store something in sharedpreference with name login. It can be email or just a string as "true"

        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("login", email);
                        editor.apply();

                        Intent intent = new Intent(DoctorLogin.this, Select_Collage.class);
                        intent.putExtra("Email", email);
                        startActivity(intent);
                        finish();

    }
}