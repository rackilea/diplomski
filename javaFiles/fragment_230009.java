Map<Character, Character> charReplacementMap = new HashMap<Character, Character>();
charReplacementMap.put('š', 's');
charReplacementMap.put('đ', 'd');
// Put more here.

String originalString = "Gračišće";
StringBuilder builder = new StringBuilder();

for (char currentChar : originalString.toCharArray()) {
    Character replacementChar = charReplacementMap.get(currentChar);
    builder.append(replacementChar != null ? replacementChar : currentChar);
}

String newString = builder.toString();