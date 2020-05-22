String punctuations = ".,;!?";
for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
    for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
        // pos could be "NN" but could also be ","
        String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
        if (punctuations.contains(pos)) {
            // do something with it
        }
    }
}