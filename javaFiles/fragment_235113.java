private static boolean check(String input) {
    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        if (Character.isLetter(ch) && input.indexOf(ch, i + 1) != -1) {
            return true;
        }
    }
    return false;
}