public static void countNoOfWords(String string) {
    int countWord = 0;
    String[] words = string.split("\\s+");
    for (String word : words) {
        if (!word.matches("\\p{Punct}+")) {
            countWord++;
        }
    }
    System.out.println("Total number of words: " + countWord);
    // selectAnalysis(string);
}