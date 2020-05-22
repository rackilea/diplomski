public static void main(String[] args) {
    String s = "xxabc\nabc";
    Pattern p = Pattern.compile("^abc");
    Matcher m = p.matcher(s);
    System.out.println(m.find());
    System.out.println(m.start());
}

false
Exception in thread "main" java.lang.IllegalStateException: No match available
    at java.util.regex.Matcher.start(Unknown Source)
    at Test.main(Test.java:10)  --> OOPs.. Not at the beginning?