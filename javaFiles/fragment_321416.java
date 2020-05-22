import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TestVoice {


    public static void main(String[] args) {

        String text = "Voice check!";

        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin");
        voice.allocate();
        voice.speak(text);

    }

}