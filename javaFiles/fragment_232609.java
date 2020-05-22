public static String encrypt (String text, String key){
    String result = "";
    for (int i = 0, j = 0; i < text.length(); i++){
        char cur = text.charAt(i);
        if (cur >= 'a' && cur <= 'z'){
            result += (char) ((cur + key.charAt(j) - 2 * 'a') % 26 + 'a');
        }
        else if (cur >= 'A' && cur <= 'Z'){
            result += (char) ((cur - 'A' + key.charAt(j) - 'a') % 26 + 'A');
        }
        else {
            result += text.charAt(i);
        }
        j = ++j % key.length();
    }
    return result;
}