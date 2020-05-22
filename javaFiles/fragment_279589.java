ArrayWrapper transcript = new ArrayWrapper(1);
transcript.addConsumer(new Consumer() {
    @Override
    public void accept(Object o) {
        // perform your operations 
        System.out.println(o);
    }
});

service.recognizeUsingWebSocket(options, new BaseRecognizeCallback() {
    @Override
    public void onTranscription(SpeechRecognitionResults speechResults) {
        for(int i = 0; i < speechResults.getResults().size(); i++){
            String newTranscript = transcript.get()[0] + speechResults.getResults().get(i).getAlternatives().get(0).getTranscript() + "\n";
            transcript.add(newTranscript, 0);
        }
    }
});