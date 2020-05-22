@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_panel);

    String usrename = getIntent().getStringExtra("username");

    NickNameText =  findViewById(R.id.nickname);
    NickNameText.setText(usrename);

    ...
}