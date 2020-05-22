@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mAudioManager=(AudioManager)getSystemService(AUDIO_SERVICE);

    setButtonClickListener();
    checkIfPhoneIsSilent();
}