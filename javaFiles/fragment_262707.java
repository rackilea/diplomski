@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.final_activity);

    name=(EditText) findViewById(R.id.editText1);
    email=(EditText) findViewById(R.id.editText2);

    String name_v=getIntent().getStringExtra("name");
    String email_v=getIntent().getStringExtra("email");
    name.setText(name_v);
    pass.setText(email_v);


}