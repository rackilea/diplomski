public static String StringtoMorse(String str){

    String MorseCode [] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|"};

    StringBuilder morse = new StringBuilder();
    for (int i = 0; i < str.length(); i ++){
        if (str.charAt(i) >= 'a' and str.charAt(i) <= 'z'){
            morse.append(MorseCode[str.charAt(i)-'a']);
            morse.append(' ');
        } else if (str.charAt(i) == ' ') {
            morse.append("| ");
        }
    }
    return morse.toString();
}