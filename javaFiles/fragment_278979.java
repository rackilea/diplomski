public static Map<String, Set<String>> getThesaurusWordsWithSynonymsMatchingGoogleWords(
      Map<String, Set<String>> tWordsWithSynonyms, Set<String> gWords) {

    Map<String, Set<String>> tWordsWithSynonymsMatchingGoogleWords = new TreeMap<>();

    for (String tWord : tWordsWithSynonyms.keySet()) {
      tWordsWithSynonyms.get(tWord).retainAll(gWords);
      tWordsWithSynonymsMatchingGoogleWords.put(tWord, tWordsWithSynonyms.get(tWord));
    }

    return tWordsWithSynonymsMatchingGoogleWords;
  }

  public static void main(String[] args) {

    Map<String, Set<String>> tWords = new HashMap<>();
    tWords.put("B", new HashSet<>(Arrays.asList("d")));
    tWords.put("A", new HashSet<>(Arrays.asList("a", "b", "c")));
    tWords.put("C", new HashSet<>(Arrays.asList("e")));

    Set<String> gWords = new HashSet<>(Arrays.asList("a", "b", "e"));

    System.out.println("Input -> thesaurusWordsWithSynonyms:");
    System.out.println(tWords);
    System.out.println("Input -> googleWords:");
    System.out.println(gWords);


    Map<String, Set<String>> result = getThesaurusWordsWithSynonymsMatchingGoogleWords(tWords, gWords);

    System.out.println("Input -> thesaurusWordsWithSynonymsMatchingGoogleWords:");
    System.out.println(result);

  }

}