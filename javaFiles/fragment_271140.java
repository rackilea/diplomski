public static String sortLetters(String str) {
   char[] chars = str.toLowerCase().toCharArray();
   Arrays.sort(chars);
   return new String(chars);
}

// first build a set of sorted words in lower case.
public static Set<String> buildLookup(Collection<String> words) {
   return words.stream().map(s -> sortLetters(s)).collect(toSet()));
}

// use the pre built set of words for the lookup.  O(1) operation for small words.
public static boolean isAnagram(Set<String> lookup, String word) {
    return lookup.contains(sortLetters(word));
}