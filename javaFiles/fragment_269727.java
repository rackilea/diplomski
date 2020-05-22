public class SpeechHelper implements OnInitListener {
    private TextToSpeech speech;
    private Context context = null;

    public SpeechHelper(Context context)
    {
        this.context = context;
        speech = new TextToSpeech(context, this);
    }

    @Override
    public void onInit(int status) {
        // TextToSpeech engine is initialized
    }
}