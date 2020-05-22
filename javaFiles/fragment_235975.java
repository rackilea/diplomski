public class NativeTTSImpl implements OnInitListener {

    private static TextToSpeech tts;
    private static boolean ttsInitialized = false;
    private static final ConcurrentLinkedQueue<String> queue = 
        new ConcurrentLinkedQueue<String>();

    public void speakString (String text) {
        if ( tts == null ) {
            tts = new TextToSpeech (AndroidNativeUtil.getActivity (), this);
        }

        if ( ttsInitialized ) {
            tts.speak (text, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            queue.add (text);
        }
    }


    public void onInit (int status) {
        if ( status == TextToSpeech.SUCCESS ) {
            tts.setLanguage (Locale.US);
            ttsInitialized = true;
            while ( !queue.isEmpty () ) {
                tts.speak (queue.poll (), TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }


    public boolean isSupported () {
        return true;
    }
}