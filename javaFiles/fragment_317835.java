String s = "one=1&two=2&=3&tr=";
Pattern patt = Pattern.compile("(?:\\w+=\\w*|=\\w+)(?:&(?:\\w+=\\w*|=\\w+))*");
Matcher m = patt.matcher(s);
if(m.matches()) {
    System.out.println("true");
} else {
    System.out.println("false");
}
//  => true