List<String> getPossibilities(String word) {
    int removeChars = word.length() - 1;
    List<String> possibilities = new ArrayList();
    List<String> options = Arrays.asList(word);
    for(int i = 0; i <= removeChars; i++) {
        List<String> results = new ArrayList();
        for(String option : options) {
          for(String result : removeOneChar(option)) {
                if(!results.contains(result)) {
                    results.add(result);
                }
            }
        }
        possibilities.addAll(results);
        options = results;
    }
    return possibilities;
}

private static List<String> removeOneChar(String word) {
    List<String> results = new ArrayList();
    for(int i = 0; i < word.length(); i++) {
        int secondPart = i + 2;
        if(secondPart <= word.length()) {
            results.add(
                    word.substring(0, i) 
                    + word.substring(i + 1, word.length()));
        }
        else {
            results.add(
                    word.substring(0, i));
        }
    }
    return results;
}