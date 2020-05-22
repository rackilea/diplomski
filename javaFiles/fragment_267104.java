private MyPreferences myPreferences;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    myPreferences = new MyPreferences(this);

    //To set EditText data from SavedPreferences
    textField.setText(myPreferences.getFunction());
}

//To save the latest data from EditText.
@Override
protected void onStop() {
    Log.d("LifeCycle", "onStop: ");
    super.onStop();
    myPreferences.setFunction(editText.getText().toString());
}