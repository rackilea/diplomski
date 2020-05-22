// method that finds and returns common words in two arrays
public static String[] wordsInBoth(String[] words1, String[] words2) { 

    Set<String> returnWords = new HashSet<String>();

    for (int i = 0; i < words1.length; i++) {
        for (int j = 0; j < words2.length; j++) {
            if (words1[i].equalsIgnoreCase(words2[j]))
                returnWords.add(words1[i]);
        }
    }

    return returnWords.toArray(new String[returnWords.size()]);
}