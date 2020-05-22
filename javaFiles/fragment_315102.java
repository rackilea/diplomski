@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // ... Other statements 

    // Initialize ringtone here
    initializeRingtone();
}

private void initializeRingtone() {
    alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
    r = RingtoneManager.getRingtone(getApplicationContext(), alert);
}