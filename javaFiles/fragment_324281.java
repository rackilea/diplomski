String s = "SUM   12  32 42 PROD 1 2";
Matcher m = Pattern.compile("(PROD|SUM)((\\s+\\d+)+)").matcher(s);
while(m.find()) {
    System.out.println("Matched : " + m.group(1));
    Matcher values = Pattern.compile("\\d+").matcher(m.group(2));
    while(values.find()) {
        System.out.println("        : " + values.group());
    }
}