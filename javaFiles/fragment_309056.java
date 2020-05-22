private static Map<String, List<String>> bucketedWords = new HashMap<>();

private static List<List<String>> _findEncodings(String number, int startAt) {
  LinkedList<List<String>> result = new LinkedList<>();
  if(startAt == number.length()) {
    result.add(new LinkedList<String>());
    return result;
  }
  for(int endAt = startAt + 1; endAt <= number.length(); endAt++) {
    List<String> words = bucketedWords.get(number.substring(startAt, endAt));
    if(words != null) {
      List<List<String>> encodings = _findEncodings(number, endAt);
      for(String word: words) {
        for(List<String> encoding: encodings) {
          List<String> enc = new LinkedList<>(encoding);
          enc.add(0, word);
          result.add(enc);
        }
      }
    }
  }
  return result;
}

private static List<List<String>> findEncodings(String number) {
  return _findEncodings(number, 0);
}

public static void main(String[] args) {
  bucketedWords.put("562", Arrays.asList("mir", "Mix"));
  bucketedWords.put("482", Arrays.asList("Tor"));
  bucketedWords.put("10", Arrays.asList("je"));
  bucketedWords.put("78", Arrays.asList("Bo\""));
  bucketedWords.put("35", Arrays.asList("da"));

  System.out.println(findEncodings("562482"));
  System.out.println(findEncodings("107835"));
}