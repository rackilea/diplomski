public class ExceptionHandling {
    /*Method that throws exception*/
    static void methodOne() throws Exception {
        System.out.println("methodOne();");
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Exception caught in methodOne(), worked up, and thrown again.");
            throw new Exception();
        }
    }

    static void methodTwo() {
        System.out.println("methodTwo();");
    }

    public static void main(String[] args) {
        try {
            methodOne();
            methodTwo();
        } catch (Exception ex) {
            System.out.println("Exception caught in main()!");
        }
    }
}