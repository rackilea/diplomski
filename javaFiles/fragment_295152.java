public class MyService extends Service {
    protected static SpeechRecognizer mSpeechRecognizer;
    protected Intent mSpeechRecognizerIntent;
    Context c;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    //if condition is met then do this
        SpeechRecognitionListener h = new SpeechRecognitionListener();
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mSpeechRecognizer.setRecognitionListener(h);
        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        Log.d("avail", " " + mSpeechRecognizer.isRecognitionAvailable(this));
        if (mSpeechRecognizer.isRecognitionAvailable(this))
            Log.d("created", "onBeginingOfSpeech");
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                this.getPackageName());
        mSpeechRecognizer.startListening(mSpeechRecognizerIntent);

        return START_STICKY;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        c= getApplicationContext();


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    class SpeechRecognitionListener implements RecognitionListener {

        @Override
        public void onReadyForSpeech(Bundle bundle) {

            Log.d("onReady", "service");
        }

        @Override
        public void onBeginningOfSpeech() {
        }

        @Override
        public void onRmsChanged(float v) {

        }

        @Override
        public void onBufferReceived(byte[] bytes) {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onError(int i) {
            Log.d("ERROR","ERROR");
        }

        @Override
        public void onResults(Bundle resultsBundle) {
            Log.d("Results", "onResults"); 
        }

        @Override
        public void onPartialResults(Bundle bundle) {

        }

        @Override
        public void onEvent(int i, Bundle bundle) {

        }
    }

  }