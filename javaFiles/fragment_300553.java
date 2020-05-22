public static void main(String[] args) {
    String a = "11111";
    String b = "10001";

    StringBuilder sb = new StringBuilder(a.length());
    for (int i = 0; i < a.length(); i++) {
        sb.appendCodePoint(a.codePointAt(i) & b.codePointAt(i));
    }
    String c = sb.toString();

    System.out.println(c);
}