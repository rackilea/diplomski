public static void main(String[] args) {
    String requeststring = "POST //upload/sendData.htm HTTP/1.1";
    String requestpattern = "^[A-Za-z]+ \\/+(\\w+)";
    Pattern p = Pattern.compile(requestpattern);
    Matcher matcher = p.matcher(requeststring);
    System.out.println(matcher.find());
    System.out.println(matcher.group(1));
}