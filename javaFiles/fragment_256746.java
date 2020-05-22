public class NumberFun {
    static String string = "*";
    static String message = "happy";

    public static void main(String args[]) {
        System.out.println(getMessage());
    }

    private static String getMessage() {
        if (string.equals("*")) {
            return message;
        }
        return "fail";
    }
}