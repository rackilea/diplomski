public static int countPossibleWord(String strMorse, String strAlpha, int inputSize) {
    if (strMorse.length() > 0) {  // still input to process
        if (strAlpha.length() >= inputSize)
            return 0; // String already has wrong size
        int count = 0;
        for (int i = 0; i < morse.length; i++) { // try all morse codes
            if (strMorse.startsWith(morse[i])) { // on the beginning of the given string
                count += countPossibleWord(strMorse.substring(morse[i].length()), strAlpha+alpha[i], inputSize);
            }
        }
        return count;
    } else {
        if( strAlpha.length() == inputSize ) {
            System.out.println( strAlpha );
            return 1; // one solution has been found
        } else {
            return 0; // String has wrong size
        }
    }
}