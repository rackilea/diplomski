public static void main(String[] args) {
    String s = "MAC 1 USD14,IPHONE4 1-2-3-4 USD22,USD44,USD66,USD88<br>";
    Pattern p = Pattern.compile("(?<=\\s|-)\\d(?=\\s|-)"); // extract a single digit preceeded and suceeded by either a space or a `-`
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group());
    }

}