@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RadioButton radioButton = (RadioButton) findViewById(R.id.radio_button);
    radioButton.setText(Constants.HelloMessage);
}