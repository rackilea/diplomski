public class Demo {

    private static final String A = "A";

    void test1(){
        String x = Demo.A;
    }

    void test2(){
        String x = "A";
    }

    void test3(){
        String x = Test.A.getTestCode();
    }

}