public static boolean contains(char[] inpt, char c, int maxIndex) {
    for(int i = 0; (i < inpt.length) && (i < maxIndex); i++) {
        if(inpt[i] == c)
            return true;
    }

    return false;
}