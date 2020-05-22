public static String deDuplicate(String input) {
    char[] inpt = input.toCharArray();
    String result = "";

    for(int i = 0; i < inpt.length; i++) {
        if(!contains(inpt, inpt[i], i)) { // Is the character already contained in the set?
            result += Character.toString(inpt[i]);
        }
    }

    return result;
}