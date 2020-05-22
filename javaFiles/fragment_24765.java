String wordToCount = "hello"; // or maybe: coming form the user!
Map<Character, Integer> numberOfRequiredCharsPerChar = new HashMap<>();

for (char charToCount : wordToCount.toCharArray()) {
  if (!numberOfRequiredCharsPerChar.containsKey(charToCount)) {
    // unknown char, so we need a counter for it
    numberOfRequiredCharsPerChar.put(charToCount, new Integer(0));
  }
  int currentCounter = numberOfRequiredCharsPerChar.get(charToCount);
  numberOfRequiredCharsPerChar.put(charToCount, currentCounter+1);
}