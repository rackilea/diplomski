public class ExceptionExample {

    private static String str;

    public static void main(String[] args) {
        try {
            System.out.println(str.length());
        } catch(NullPointerException npe) {
            npe.printStackTrace();
        }
        System.out.println("Does this execute?");
    }
}