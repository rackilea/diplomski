@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    // view references
    username = findViewById(R.id.emailtext);
    password1 = findViewById(R.id.pwdtext);
    clientID = findViewById(R.id.clientidtxt);

    SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

    // Set the views here with the values found from your SharedPreferences. 
    // In the first time, there is no value stored, hence the default empty string will be put.
    username.setText(prefs.getString("name", ""));
    password1.setText(prefs.getString("password", ""));
    clientID.setText(prefs.getString("id", ""));

    Button button3=findViewById(R.id.button);
    button3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
            editor.putString("name", username.getText().toString());
            editor.putString("password", password1.getText().toString());
            editor.putString("id", clientID.getText().toString());
            editor.apply();

            Intent activity2Intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(activity2Intent);
        }
    }
}