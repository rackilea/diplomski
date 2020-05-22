public static void main(String[] args) {
    String s = "abcabc";
    Pattern p = Pattern.compile("abc$");
    Matcher m = p.matcher(s);
    System.out.println(m.find());
    System.out.println(m.start()); // prints starting index of match
}