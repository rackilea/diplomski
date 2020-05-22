public class TestString {

    public static void main(String[] args) {
        String stackOverflow = "stackOverflow";
        String overflow = "Overflow";

        final String overflowFinal = "Overflow";

        if (overflow == overflowFinal) {
            System.out.println("Both overflows are same!");
        }

        if (stackOverflow == ("stack" + overflow)) {
            System.out.println("Stack and overflow have same reference !");
        }

        if (stackOverflow == ("stack" + overflowFinal)) {
            System.out.println("Stack and overflowFinal have same reference !");
        }
    }

}