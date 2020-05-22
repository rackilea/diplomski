public static void main(String[] args) {
    String REGEX = "1\n2";
    Pattern p = Pattern.compile(REGEX, Pattern.DOTALL);
    Matcher m = p.matcher("test1\n2test");
    String newText = m.replaceAll("abcd");
    System.out.println(newText);
}