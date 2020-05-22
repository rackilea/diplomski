public static void main(String[] args) {
    final String input = "This is a sentence that is containing three times the word is";
    final char   token = '#';

    String processedInput  = "";
    String currentWord     = "";
    int    wordCount       = 0;
    int    uniqueWordCount = 0;

    for (char c : input.toCharArray()) {
        if (c != ' ') {
            processedInput += c;
            currentWord    += c;
        } else {
            processedInput += token;
            wordCount++;

            String  existingWord      = "";
            int     occurences        = 0;

            for (char c1 : processedInput.toCharArray()) {
                if (c1 != token) {
                    existingWord += c1;
                } else {
                    if (existingWord.equals(currentWord)) {
                        occurences++;
                    }

                    existingWord = "";
                }
            }

            if (occurences <= 1) {
                System.out.printf("New word: %s\n", currentWord);
                uniqueWordCount++;
            }

            currentWord = "";
        }
    }
    wordCount++;


    System.out.printf("%d words total, %d unique\n", wordCount, uniqueWordCount);
}