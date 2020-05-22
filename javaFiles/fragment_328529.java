public static void main(String[] args) {
    String str = "FEES_1 > 100 AND FEES_2 <= 200 OR FEES_3 <= 500";
    Pattern p = Pattern.compile("(?:^|(AND|OR))\\s*(\\w+)\\s+([<>]=?)\\s+(\\d+)\\s*(?=(AND|OR|$))");
    Matcher m = p.matcher(str);
    for (int i = 0; m.find(); i++) {
        System.out.println("Iteration " + (i + 1) + ":");
        System.out.println(String.format("Operands: [%s ,  %s ]", m.group(2), m.group(4)));
        System.out.println("Relational Operator: " + m.group(3));
        System.out.println("Conditional Operator: " + m.group(1));
        System.out.println();
    }
}