String s = "asd321tre2";
    char[] charr = s.toCharArray();
    int end = 0;

    for (int i = s.length(); i <= 0; i--) {
        if (Character.isLetter(charr[i])) {
            end = i;

        }
    }
    String output = charReplace(end, charr);
}

private static String charReplace(int end, char[] ch) {

    for (int i = 0; i < ch.length; i++) {
        if (Character.isLetter(ch[i])) {
            char tmp = ch[i];
            ch[i] = ch[end];
            ch[end] = tmp;
        }
    }
    String output = String.valueOf(ch);
    return output;

}