public static void main(String[] args) throws Exception {
    String case1 = "project/emp-id1545/ID-JHKDKHENNDHJSJ";
    String case2 = "project/**dep**/emp-id8545/ID-GHFRDEEDE";

    Matcher matcher = Pattern.compile("emp-id\\d+").matcher(case1);
    // Changed from while to if cause we're only going to get the first match
    if (matcher.find()) {
        System.out.println(matcher.group());
    }

    matcher = Pattern.compile("emp-id\\d+").matcher(case2);
    // Changed from while to if cause we're only going to get the first match
    if (matcher.find()) {
        System.out.println(matcher.group());
    }
}