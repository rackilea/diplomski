public class TextToSpeechInitializer{

private Context context;
private static TextToSpeech talk;
private TextToSpeechIniListener callback;
private Locale locale;

public TextToSpeechInitializer(Context context , Locale locale , TextToSpeechIniListener l) {
    this.context = context;
    if(l != null) {
        callback = l;
    }
    this.locale = locale;
    initialize();
}


private void initialize() {
    talk = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                talk.setLanguage(locale); //TODO: Check if locale is available before setting.
                callback.onSucces(talk);
            }else{
                callback.onFailure(talk);
                Log.e("TTS","TextToSpeechInitializeError");
            }
        }
    });
}
}