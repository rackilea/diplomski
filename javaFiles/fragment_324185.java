Map<Character, Character> charReplacementMap = new HashMap<Character, Character>() {{
    put('Ü', 'Y');
    // Put more here.
}};

String originalString = "AÜAÜ";
StringBuilder builder = new StringBuilder();

for (char currentChar : originalString.toCharArray()) {
    Character replacementChar = charReplacementMap.get(currentChar);
    builder.append(replacementChar != null ? replacementChar : currentChar);
}

String newString = builder.toString();