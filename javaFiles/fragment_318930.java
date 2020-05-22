public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        System.out.println(Test.class.getResource("/res/0.jpg"));
        System.out.println(getClass().getResource("/res/0.jpg"));
    }

}