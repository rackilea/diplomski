public static long countUpperCase(final String str) {
    long counter = 0;

    for(final char c: str.toCharArray()) {
        if(Character.isUpperCase(c)) {
            counter++;
        }
    }
    return counter;
}