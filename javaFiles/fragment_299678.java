public static boolean isValid(String str) {

    if(str.matches("[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]{1}")) {
        int num = Integer.parseInt(str.replaceAll("[^0-9]", ""));
        if(LETTERS[num%LETTERS.length] == str.charAt(8) ) {
            return true;
        }
    }
    return false;
}