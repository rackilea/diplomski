public static void main(String[] args){
    String s  = "This is a new direction. Address located. " +
            "\n\n\n 0.35 miles from location";
    Pattern p = Pattern.compile("(\\d+\\.\\d+)");
    Matcher m = p.matcher(s);
    while (m.find()) {
      System.out.println(m.group());
    }
}