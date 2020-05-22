public static void main(String[] args) throws Exception {
    String case1 = "project/emp-id1545/ID-JHKDKHENNDHJSJ";
    String case2 = "project/**dep**/emp-id8545/ID-GHFRDEEDE";

    System.out.println(Arrays.stream(case1.split("/")).filter(s -> s.startsWith("emp-id")).findFirst().get());
    System.out.println(Arrays.stream(case2.split("/")).filter(s -> s.startsWith("emp-id")).findFirst().get());
}