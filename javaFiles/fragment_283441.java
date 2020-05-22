private String usernameApi;
private String passwordApi;
private EditText usernameet;
private EditText passwordet;
private Button login_btn;
private List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    usernameet = findViewById(R.id.username_etext);
    passwordet = findViewById(R.id.password_etext);
    login_btn = findViewById(R.id.login_btn);
    login_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        login(usernameet.getText().toString(), passwordet.getText().toString());
                    }
                });
    getRetrofitArray();
}