@Override
public void onInit(int status) {
  if (status == TextToSpeech.SUCCESS) {
    tts.setLanguage(Locale.UK);
    Log.d("onInit", activity.toString());

    ((MainActivity)activity).ttsReady();
  }
}