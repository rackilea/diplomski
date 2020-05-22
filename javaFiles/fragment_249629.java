public static void main (String[] args) {

    String name1 = "1.0.1 4C0";
    String name2 = "1.0.1 B 4BD";
    String name3 = "1.0.4.52A";
    String name4 = "1.0.2 Build S6B5";

    check(name1);
    check(name2);
    check(name3);
    check(name4);
}

private static void check(String name) {

    Pattern p = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)\\s+Build\\s+([SDT]\\w{3,4})");
    Matcher m = p.matcher(name);

    if (m.find()) {
        System.out.println("num1: " + m.group(1));
        System.out.println("num2: " + m.group(2));
        System.out.println("num3: " + m.group(3));
        System.out.println("build: " + m.group(4));
    } else {
        System.out.println("not found");
    }
}