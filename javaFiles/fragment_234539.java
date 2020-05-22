public static void main(String[] args) {
    String s = "True && False & True but & is & right?";
    Pattern p = Pattern.compile("(?<!&)&(?!&)");
    Matcher m = p.matcher(s);
    while (m.find()) {
    // can keep counter and add +1 here
        System.out.println(m.group());
    }

}