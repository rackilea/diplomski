Button button;
Spinner spinner; 

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    spinner = (Spinner)findViewById(R.id.spinner1);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
    this, R.array.MyPictures, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);


    button = (Button) findViewById(R.id.button02);
    button.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
          Intent mSignup = new Intent(activityOne.this, activityTwo.class);
          startActivity(mSignup);
        }
    });

}