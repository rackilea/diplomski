class Listener implements RecognitionListener {

    private String match = null;

    ....

    public void onResults(Bundle arg0) {
       ArrayList<String> matches = arg0.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
       this.match = matches.get(0);
    }

    /**
     * Get the match
     * can return null if onResults not called or matches.get(0) == null
     */
    public String getMatch() {
        return match;
    }

}