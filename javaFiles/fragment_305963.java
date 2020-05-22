public static void main(String[] args) {
    Pattern pattern = Pattern.compile("^(//([^\\\\]*)\\\\n)?(.*)$");
    Matcher matcher = pattern.matcher("//;\\n123");
    System.out.println(matcher.matches()); //   output: true
    System.out.println(matcher.group(0));  //   output: //;\n123
    System.out.println(matcher.group(1));  //   output:  //;\n
    System.out.println(matcher.group(2));  //   output: ;
    System.out.println(matcher.group(3));  //   output: 123
}