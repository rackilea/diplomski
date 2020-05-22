public static int countUniqueCharacters(String text1) {
    int count = 0;
    for (int i = 0; i < text1.length(); i++) {
        if (text1.substring(0, i).contains(text1.charAt(i) + "")) {
            System.out.println();
        } else if (Character.isLetter(text1.charAt(i)) || Character.isDigit(text1.charAt(i))) {
            count++;
        }
    }
    return count;
}