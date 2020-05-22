public static void performRegexReplacement() {
    // Construct a test mapper/dictionary
    List<Map<String, String>> dictionnary = Arrays.asList(Collections.singletonMap("TRSS190E", "TRST0822"), Collections.singletonMap("TRSP1143", "TRSP6644"), Collections.singletonMap("TRSM0146", "TRSM1273"));

    // Perform replacement
    String corpus = "Hey there! I think TRSS190E is a very important parameter for the rover. " +
            "Because the Martian atmosphere also requires TRSP1143 and TRSM0146 for it's " +
            "platform and mobility subsystems.";

    String expectedCorpus = "Hey there! I think TRST0822 is a very important parameter for the rover. " +
            "Because the Martian atmosphere also requires TRSP6644 and TRSM1273 for it's " +
            "platform and mobility subsystems.";

    String updatedCorpus = corpus;
    for(Map<String,String> replacement : dictionnary){
        updatedCorpus = replaceWords(updatedCorpus, replacement);
    }

    System.out.println(updatedCorpus);

    if(expectedCorpus.equals(updatedCorpus)){
        System.out.println("yay");
    } else {
        System.out.println("no");
    }
}