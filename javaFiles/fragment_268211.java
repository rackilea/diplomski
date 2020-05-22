public static void main(String... args) {
    System.out.println(arabicToDecimal("۴۲"));
}

private static final String arabic = "\u06f0\u06f1\u06f2\u06f3\u06f4\u06f5\u06f6\u06f7\u06f8\u06f9";
private static String arabicToDecimal(String number) {
    char[] chars = new char[number.length()];
    for(int i=0;i<number.length();i++) {
        char ch = number.charAt(i);
        int index = arabic.indexOf(ch);
        if (index >= 0)
            ch = (char) (index + '0');
        chars[i] = ch;
    }
    return new String(chars);
}