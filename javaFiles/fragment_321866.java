Configuration configuration = new Configuration();
    // Load model from the jar
    configuration
            .setAcousticModelPath("resource:/edu/cmu/sphinx/models/acoustic/wsj");
    configuration
            .setDictionaryPath("resource:/edu/cmu/sphinx/models/acoustic/wsj/dict/cmudict.0.6d");
    configuration
            .setLanguageModelPath("resource:/edu/cmu/sphinx/models/language/en-us.lm.dmp");

    StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(
            configuration);
    InputStream stream = TranscriberDemo.class
            .getResourceAsStream("/edu/cmu/sphinx/demo/aligner/10001-90210-01803.wav");

    // Simple recognition with generic model
    recognizer.startRecognition(stream);
    SpeechResult result;
    while ((result = recognizer.getResult()) != null) {
        System.out.format("Hypothesis: %s\n", result.getHypothesis());
        System.out.println("List of recognized words and their times:");
        for (WordResult r : result.getWords()) {
            System.out.println(r);
        }
    }
    recognizer.stopRecognition();