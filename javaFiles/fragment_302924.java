public static String encrypt(String s1, String s2, int everyX) {
    //Start with S2
    StringBuilder finalS2 = new StringBuilder(s2);
    s1 = s1.toLowerCase();

    int indexInS1 = 0;
    //Whilst there are characters in S2 and S1 left to iterate over
    for (int placeInS2 = 0; placeInS2 < finalS2.length() && indexInS1 < s1.length(); placeInS2++) {
         //Has there been everyX places encountered and the character in S1 is alphanumeric
        if ((placeInS2 + 1) % everyX == 0) {
            if (Character.isAlphabetic(s1.charAt(indexInS1)) {
                finalS2.setCharAt(placeInS2, s1.charAt(indexInS1));
            }
            indexInS1++;
        }
    }

    return finalS2.toString();
}