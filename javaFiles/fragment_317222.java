class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getResource("/text.txt"));
        System.out.println(Test.class.getResource("/folder"));
    }
}