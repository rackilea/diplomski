String utenRepetisjon(String tekst) {
    String str = "";
    for(char ch : tekst.toCharArray()) {
        if (str.indexOf(ch) == -1) {
            str += ch;
        }
    }
    return str;
}