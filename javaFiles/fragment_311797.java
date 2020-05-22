public class Registration extends AppCompatActivity {
    EditText ET_USER_LOCATION, ET_USER_MAIL, ET_USER_NAME, ET_USER_PASS;
    String method, user_location, user_mail, user_name, user_pass;
    Button registerButton;
    Context mContext;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference users = database.getReference("UserApp");
    String key = users.child("UserApp").push().getKey();
    String token = FirebaseInstanceId.getInstance().getToken();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mContext = this;

        ET_USER_LOCATION = (EditText) findViewById(R.id.new_user_location);
        ET_USER_MAIL = (EditText) findViewById(R.id.new_user_mail);
        ET_USER_NAME = (EditText) findViewById(R.id.new_user_name);
        ET_USER_PASS = (EditText) findViewById(R.id.new_user_pass);

        registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_location = ET_USER_LOCATION.getText().toString();
                user_mail = ET_USER_MAIL.getText().toString();
                user_name = ET_USER_NAME.getText().toString();
                user_pass = ET_USER_PASS.getText().toString();

                users.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String result = registerWithoutRepetition(dataSnapshot);
                        Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
                        if(Objects.equals(result, "Login Success")){
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }





    private void writeNewUser(String user_id, String user_name, String user_mail, String user_pass, String user_location, String user_token) {
        UserApp user = new UserApp(user_name, user_mail, user_pass, user_location, user_token);

        users.child(user_id).setValue(user);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String registerWithoutRepetition(DataSnapshot dataSnapshot){
        for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
            UserApp userApp = snapshot.getValue(UserApp.class);
            if (Objects.equals(userApp.user_name, user_name)) {
                return "Username is already registered, try again";
            }
        }
        writeNewUser(key, user_name, user_mail, user_pass, user_location, token);
        return "Login Success";
    }