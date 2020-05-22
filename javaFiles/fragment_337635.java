public String findAnagram(String sc) {
    String anagramOutput = "putWhateverYouWantToPut";
    for (int i = 0; i < sc.length(); i++) {
        for (int j = i + 1; j < sc.length(); j++) {
            if (sc.charAt(i) == sc.charAt(j)) {
                anagramOutput = "anagram";
            } else {
                anagramOutput = "not anagram";
            }
            return anagramOutput;
        }
    }
    return anagramOutput;
}