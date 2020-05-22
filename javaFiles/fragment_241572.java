class Test {

    private int sum;

     public Test(Object otherObj) {
        if (otherObj != null){
           sum = 42;
           return;
        }
        sum = 0;
     }

    public static void main(String[] args) {
        Test testZero = new Test(null);
        Test testNonZero = new Test(testZero);

        System.out.println(testZero.sum);       // 0
        System.out.println(testNonZero.sum);    // 42
    }
}