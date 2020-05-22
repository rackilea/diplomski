private Button v;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    v = (Button) findViewById(R.id.bSignUpHere);
    v.setOnClickListener(SignUpOnClick);


}

View.OnClickListener SignUpOnClick = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, signup.class);
        startActivity(i);
    }
};