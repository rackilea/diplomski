public static void printWhatQualifies(String[] data, int qualifyingLength) {
    for(String string: data) {
        if(qualifyingLength == string.length()) {
            System.out.println(string);
        }
    }
}