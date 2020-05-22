public class UnicodePrinter {
    public static void main(String args[])
    {
        for (char i = '\u6000'; i < '\u7000'; i++) {
            if (i % 50 == 0) {
                System.out.println();
            }
            System.out.print(i); //issue here, see below
        }
    }
}