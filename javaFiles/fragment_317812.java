public static void main(String[] args) {
    String searchString = "(7,32)";
    Pattern compile1 = Pattern.compile("(?<=\\()\\d+(?=,)");
    Pattern compile2 = Pattern.compile("(?<=,)\\d+(?=\\))");
    Matcher matcher1 = compile1.matcher(searchString);
    Matcher matcher2 = compile2.matcher(searchString);
    while (matcher1.find() && matcher2.find()) {
        String group1 = matcher1.group();
        String group2 = matcher2.group();
        System.out.println("value 1: " + group1 + " value 2: " + group2);
    }
}