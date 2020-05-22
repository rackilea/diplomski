final String[] transcript = {""};
    Consumer<String> consumer = new Consumer<String>() {
        @Override
        public void accept(String s) {
            //your operations
            System.out.println(s);
        }
    };
    service.recognizeUsingWebSocket(options, new BaseRecognizeCallback() {
        @Override
        public void onTranscription(SpeechRecognitionResults speechResults) {
            for(int i = 0; i < speechResults.getResults().size(); i++){
                transcript[0] = transcript[0] + speechResults.getResults().get(i).getAlternatives().get(0).getTranscript() + "\n";
                consumer.accept(transcript[0]);
            }
        }
    });
}