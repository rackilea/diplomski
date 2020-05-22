public static String replaceChar(String word, String secret, char c) {
    for (int i = 0; i < word.length(); i++) {
        if (secret.charAt(i) == c) {
            word = word.substring(0, i) + c + word.substring(i+1); 
        }
    }
    return word;
}