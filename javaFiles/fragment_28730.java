AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        audioManager = ((AudioManager)getSystemService(Context.AUDIO_SERVICE));
    ...
    }