public static void main(String[] args) throws ParseException {
    Pattern p = Pattern.compile("\\d\\d\\d");
    Matcher m = p.matcher("a123b");
    System.out.println(m.find());
    System.out.println(m.matches());

    p = Pattern.compile("^\\d\\d\\d$");
    m = p.matcher("123");
    System.out.println(m.find());
    System.out.println(m.matches());
}

/* output:
true
false
true
true
*/