for (int i = 0; i < length; i++) {
    if (match.contains(i))
        continue;

    // String to match
    String toMatch = input.substring(i,i+1);

    for (int j = 0; j < modOracle.length; j++) {
        if (toMatch.equals(modOracle.substring(j,j+1))) {
            close.add(i);
            // then remove this letter from modOracle
            // need small utility method for this.
            break;
        }
    }
}