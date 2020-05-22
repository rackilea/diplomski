public static void main(String[] args) throws Exception {
    String case1 = "project/emp-id1545/ID-JHKDKHENNDHJSJ";
    String case2 = "project/**dep**/emp-id8545/ID-GHFRDEEDE";

    int index = case1.indexOf("emp-id");
    System.out.println(case1.substring(index, case1.indexOf("/", index)));

    index = case2.indexOf("emp-id");
    System.out.println(case2.substring(index, case2.indexOf("/", index)));
}