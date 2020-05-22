public static void main(String []args) {
    Test<String,Integer> test = new MapStringToIntAddtionOperation();
    test.add("1");
    test.add("2");
    System.out.println(test.performOperation(Integer::parseInt));
}