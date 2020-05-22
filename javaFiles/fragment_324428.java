public static void main(String[] args) {
    String someInput = "XXX-payload-YYY-some-tail";
    Pattern r = Pattern.compile("(XXX)(.*)(YYY)(.*)");
    Matcher m = r.matcher(someInput);

    if (m.matches()) {
        System.out.println("initial token: " + m.group(1));
        System.out.println("payload: " + m.group(2));
        System.out.println("end token: " + m.group(3));
        System.out.println("tail: " + m.group(4));
    }
}