int possibleCounts = 0;
String inputToCountOn = ....

Map<Character, Integer> numberOfUsedCharacters= new HashMap<>(numberOfRequiredCharsPerChar);

for (char availableChar : inputToCountOn()) {
  if (numberOfUsedCharacters.containsKey(availableChar)) {
    int currentCounter = numberOfUsedCharacters.get(availableChar);
    currentCounter--;
    if (currentCounter == 0) {
      numberOfUsedCharacters.remove(availableChar);
    } else {
      numberOfUsedCharacters.put(availableChar, currentCounter);
    }
    if (umberOfUsedCharacters.isEmpty()) {
      // that means: we fetched ALL chars we need to print the word ONCE
      possibleCounts++;
      // and reset our "counter" map
      numberOfUsedCharacters= new HashMap<>(numberOfRequiredCharsPerChar);
   }
}
... now you just print possibleCounts ...