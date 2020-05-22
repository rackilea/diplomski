public int findLongestSentence(String paragraph) {
    String[] sentences = paragraph.split("\\.|\\!|\\?");
    int maxSentenceLength = 0;

    for(String sentence : sentences) {
        String[] words = sentence.split("\\s");
        maxSentenceLength = Math.max(words.length, maxSentenceLength);
    }

    return maxSentenceLength;
}