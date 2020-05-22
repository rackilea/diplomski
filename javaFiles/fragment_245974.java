public static boolean checkPostcode(String postCode) {
    if (postCode.length() != lengthPost || postCode.charAt(0) == '0') {
        return false;
    }
    if (postCode.length() == lengthPost) {
        for (int i = 0; i < postCode.length(); i++) {
            if (i < 4 && Character.isLetter(postCode.charAt(i))) {
                return false;
            }
            if (i > 3 && Character.isDigit(postCode.charAt(i))) {
                return false;
            }
        }
    }
    return true;
}