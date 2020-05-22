public static String toPigLatin(String text) {


    String ret = "";
    String vowelbuf = "";


    for (int i = 0; i < text.length(); ++i) {
        char x = text.charAt(i);
        if (isVowel(x)) {
            vowelbuf += x;
        } else {
            if (vowelbuf.length() > 0) {
                ret += vowelbuf + "b" + vowelbuf + x;
                vowelbuf = "";
            } else {
                ret += x;
            }
        }
    }
    if (vowelbuf.length() > 0) {
        ret += vowelbuf + "b" + vowelbuf;
    }
    return ret;
}