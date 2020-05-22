if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Log.e("TTS", "Language is not supported");
        } else {
            button1.setEnabled(true);
          //  speakOut();
        }