Context context;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        audioManager = ((AudioManager)context.getSystemService(Context.AUDIO_SERVICE));
    ...
    }