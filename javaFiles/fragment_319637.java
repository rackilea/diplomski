@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.myphone);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    //Getting the edittext and button instance
    edittext1 = (EditText) findViewById(R.id.editText);
    button1 = (Button) findViewById(R.id.btnCall);
    sendBtn = (Button) findViewById(R.id.btnSendSMS);
    txtMessage = (EditText) findViewById(R.id.editText2);

    //Performing action on button click
    button1.setOnClickListener(this::makeCall());

    sendBtn.setOnClickListener((view) - >{
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d("PLAYGROUND", "Permission is not granted, requesting");
            ActivityCompat.requestPermissions(this, new String[] {
                Manifest.permission.SEND_SMS
            },
            MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            Log.d("PLAYGROUND", "Permission is granted");
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(
            edittext1.getText().toString(), null, txtMessage.getText().toString(), null, null);

            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }
    });
}