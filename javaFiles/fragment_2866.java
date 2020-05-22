@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);


    relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

    checkIfPhoneIsSilent();
    setUpImage();

}