public static int countChar(String str, String character) {
    if(str.length()==0) {
        return 0;
    }

    if ((str.substring(0,1).equals(character))) {
        return 1 + countChar(str.substring(1), character);
    }

    return countChar(str.substring(1), character);
}