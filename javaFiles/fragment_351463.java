public class FinallyTest {

    public static void main(String[] args) throws Exception {
        try {
            boolean flag = true;
            if (flag) {
                throw new Exception("hello");
            }
        } finally {
            System.out.println("this will get printed");
        }
        System.out.println("this won't show up");
    }
}