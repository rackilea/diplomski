public static int matchStrings(String firstString, String SecondString) {

    int matchingCount = 0;

    //Getting the whole set of words in to array. 
    String[] allWords = firstString.split("\\s");
    Set<String> firstInputset = new HashSet<String>();

    //getting unique words in to set
    for (String string : allWords) {
        firstInputset.add(string);
    }

    //Loop through the set and check whether number of words occurrence in second String
    for (String string : firstInputset) {
        if (SecondString.toLowerCase().contains(string.toLowerCase())) {
            matchingCount++;
        }
    }
    return matchingCount;
}