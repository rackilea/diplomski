package com.madmob.test;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TestTTS {
    VoiceManager freettsVM;
    Voice freettsVoice;

    public TestTTS(String words) {
        // Most important part!
        System.setProperty("mbrola.base", "C:/mbrola");
        freettsVM = VoiceManager.getInstance();

        // Simply change to MBROLA voice
        freettsVoice = freettsVM.getVoice("mbrola_us1");

        // Allocate your chosen voice
        freettsVoice.allocate();
        sayWords(words);
    }

    public void sayWords(String words) {
        // Make her speak!
        freettsVoice.speak(words);
    }

    public static void main(String [] args) {
        new TestTTS("Hello there! Now M BROLA and Free T T S work together!");
    }
}