private TextView BaconText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bacon);
    BaconText = (TextView) findViewById(R.id.baconText);

    Bundle applesData = getIntent().getExtras(); //Call intent and store the extras in applesdata

    if(applesData == null){
      BaconText.setText("Must type something, sending you back...");
        Thismethodiscalledonclick(null); //Take them back to first screen

        return;
    }

    String applesDataReceived = applesData.getString("applesMessageKey");
    BaconText.setText(applesDataReceived);
}

public void Thismethodiscalledonclick(View v){
    Intent i = new Intent(this, MainActivity.class);
    startActivity(i);

}