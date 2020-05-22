public static long countUpperCase(final String str) {
    long counter = 0;

    for(int i=0; i<str.length(); i++) {
        if(Character.isUpperCase(str.charAt(i))) {
            counter++;
        }
    }
    return counter;
}