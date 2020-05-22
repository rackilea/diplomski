private static List<List<String>> combinationFinder(String str) {
    if (str.isEmpty()) {
        return Collections.singletonList(Collections.emptyList());
    }
    List<List<String>> result = new ArrayList<>();
    // can we split off 1 char from the start? requires just non-zero
    if (str.charAt(0) != '0') {
        String firstChar = str.substring(0, 1);
        if (!Character.isDigit(firstChar.charAt(0))) {
            throw new IllegalArgumentException("Not a digit: " + firstChar);
        }
        List<List<String>> combinationsOfRemainingStr 
                = combinationFinder(str.substring(1));
        addAllCombos(result, firstChar, combinationsOfRemainingStr);
    }
    // can we split off 2 chars?
    if (str.length() >= 2) {
        String firstSubstring = str.substring(0, 2);
        int firstNumber = Integer.parseInt(firstSubstring);
        if (firstNumber >= 1 && firstNumber <= 26) { // OK
            List<List<String>> combinationsOfRemainingStr 
                    = combinationFinder(str.substring(2));
            addAllCombos(result, firstSubstring, combinationsOfRemainingStr);
        }
    }
    return result;
}

/** adds to result all lists made up of firstElement followed by a list from remainingElements */
private static void addAllCombos(List<List<String>> result,
        String firstElement, List<List<String>> remainingElements) {
    for (List<String> remCombo : remainingElements) {
        List<String> totalCombo = new ArrayList<>(1 + remCombo.size());
        totalCombo.add(firstElement);
        totalCombo.addAll(remCombo);
        result.add(totalCombo);
    }
}