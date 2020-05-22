class Listener implements RecognitionListener {

   ....

   public String onResults(Bundle arg0) {
      ArrayList<String> matches = arg0.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
      return matches.get(0);
   }

}