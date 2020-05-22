// TTSActivity.java
public abstract class TTSActivity extends Activity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.UK);

            ttsReady();
        }

    }

    public void speakText(String toSpeak) {
        int mode = android.speech.tts.TextToSpeech.QUEUE_FLUSH;
        tts.speak(toSpeak, mode, null);
    }

    protected TextToSpeech getTts() {
        return tts;
    }

    protected abstract void ttsReady();
}