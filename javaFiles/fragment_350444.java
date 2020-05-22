@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_settings);

phoneNum = (EditText)findViewById(R.id.phoneNum);
msgCounter = (EditText)findViewById(R.id.msgCount);
apply = (Button)findViewById(R.id.butto);
save = (Button)findViewById(R.id.butt);


save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent pass = new Intent();
        pass.putExtra("value", phoneNum.getText().toString());
        pass.putExtra("cost",msgCounter.getText().toString());
        setResult(Activity.RESULT_OK,pass);
        finish();
    }
});