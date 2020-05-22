Intent voicerecogize = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

voicerecogize.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
voicerecogize.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, ecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
voicerecogize.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-EG");

startActivityForResult(voicerecogize, RESULT_SPEECH);