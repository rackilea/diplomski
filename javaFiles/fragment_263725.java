public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = findViewById(R.id.et);
        Button btnRegister = findViewById(R.id.btn_register);
        Button btnLogin = findViewById(R.id.btn_login);



        pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("username", et.getText().toString());
                editor.putBoolean("isOnline", false);
                editor.apply();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et.getText().toString().equals(pref.getString("username", null))) {

                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("name", et.getText().toString());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    editor.putBoolean("isOnline", true);
                    editor.apply();

                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, "Incorrect input", Toast.LENGTH_LONG).show();
                }
            }
        });

// This is when user has not clicked the log out button, then we go to the WelcomeActivity instead
        if (pref.getBoolean("isOnline", false)) {

            startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
            finish();
        }
    }
}