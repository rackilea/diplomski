public static void getRepeatCount(String[] c) {
    HashMap<String, Integer> wordCount = new HashMap<>();
    for(String currStr : c) {
        if(wordCount.containsKey(currStr)) {
            wordCount.put(currStr, wordCount.get(currStr) + 1);
        } else {
            wordCount.put(currStr,1);
        }
    }
    int repeatedWords = 0;
    for (String currKey : wordCount.keySet()) {
        int currRepeatCount = wordCount.get(currKey);
        repeatedWords += currRepeatCount;
        System.out.println(currKey+" => "+currRepeatCount);
    }
    System.out.println("Total reapeated words: "+repeatedWords);
}