public static void smallestWord() {
    String smallestWord = null;
    List<String> words = new ArrayList<>();
    words.add("dba");
    words.add("dba");
    words.add("eba");
    words.add("dca");
    words.add("eca");

    for (String word : words) {
        if ((smallestWord == null) || (word.compareTo(smallestWord) < 0)) {
            smallestWord = word;
        }
    }
}