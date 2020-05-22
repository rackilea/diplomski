public class Registration_Activity extends AppCompatActivity {

    EditText reg_email,reg_phone,reg_password;
    Button reg_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final DatabaseHandler db = new DatabaseHandler(this, null, null, 2);
        reg_email = (EditText)findViewById(R.id.reg_email);
        reg_phone = (EditText)findViewById(R.id.reg_phone);
        reg_password = (EditText) findViewById(R.id.reg_password);
        reg_button = (Button)findViewById(R.id.reg_button);
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = reg_email.getText().toString();
                String phone = reg_phone.getText().toString();
                String password = reg_password.getText().toString();
                if (email.matches(emailPattern)) {
                    DatabaseHandler db = new DatabaseHandler(Registration_Activity.this, null, null, 2);
                    UserRegister userRegister = new UserRegister();
                    userRegister.setEmailId(email);
                    userRegister.setMobNo(phone);
                    userRegister.setPassword(password);
                    db.addregister(userRegister);
                    Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration_Activity.this, Login_Activity.class);
                    startActivity(intent);
                    Registration_Activity.this.finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter a valid Email Address",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}