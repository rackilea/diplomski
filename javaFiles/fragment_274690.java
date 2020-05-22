//MainActivity.java
    private BroadcastReceiver intentReceiver; // do not set it up here. We'll set it and register it onCreate(), but we'll keep it here so it stays on scope of every other function
    private IntentFilter intentFilter; // same for the filter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // We'll set up the receiver here, after the activity starts
        intentReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                TextView chargeText = (TextView) findViewById(R.id.chargeText);
                Log.d("myTag", "is chargeText null? : " + (chargeText==null));

                Log.d("myTag", "The text is: " + (intent.getExtras().getString("message")));

                String text = intent.getExtras().getString("message").toString(); // let's try this with toString() so we are very explicit about it

                Log.d("myTag", "The converted text is: " + text);

                chargeText.setText(text);
            }
        };

        // then, we'll create the filter
        intentFilter = new IntentFilter();

        intentFilter.addAction("SMS_RECEIVED_ACTION");
        button3 = (Button) findViewById(R.id.button);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mymsg = "CMDACC_1234";
                String thenumber = "09380638202";
                SendChargeMessage(thenumber, mymsg);
            }
        });

        registerReceiver(intentReceiver , intentFilter); // registering
    }

    public void SendChargeMessage(String thenumber, String mymsg) {
        String SENT = "Message sent";
        String DELIVERED = "Message delivered";
        SmsManager smsManager = SmsManager.getDefault();
        Context curContext = this.getApplicationContext();
        PendingIntent sentPending = PendingIntent.getBroadcast(curContext, // Are you sure you want to create a new intent here?
                0, new Intent("SENT"), 0);
        curContext.registerReceiver(new BroadcastReceiver() { // and are you sure this is supposed to be a new receiver as well? Are you registering it like we did with iontentReceiver?
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "Sent.",
                                Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Not Sent: Generic failure.",
                                Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "Not Sent: No service (possibly, no SIM-card).",
                                Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Not Sent: Null PDU.",
                                Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Not Sent: Radio off (possibly, Airplane mode enabled in Settings).",
                                Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }, new IntentFilter("SENT"));

        PendingIntent deliveredPending = PendingIntent.getBroadcast(curContext, 
                0, new Intent("DELIVERED"), 0);

        curContext.registerReceiver( 
                new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context arg0, Intent arg1) {
                        switch (getResultCode()) {
                            case Activity.RESULT_OK:
                                Toast.makeText(getBaseContext(), "Delivered.",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case Activity.RESULT_CANCELED:
                                Toast.makeText(getBaseContext(), "Not Delivered: Canceled.",
                                        Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                }, new IntentFilter("DELIVERED"));

        PackageManager pm = this.getPackageManager();

        if (!pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY) &&
                !pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA)) {
            Toast.makeText(this, "Sorry, your device probably can't send SMS...", Toast.LENGTH_SHORT).show();
        } else {
            smsManager.sendTextMessage("09380638202", null, "CMDACC_1234", sentPending, deliveredPending);
            //chargeText.setText(SMSBody1);
        }
    }