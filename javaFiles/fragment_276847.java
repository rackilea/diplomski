public class Average3 {
    static class InputData {
        public int number1;
        public int number2;
        public int number3;

        public int average() {
            return (number1 + number2 + number3) / 3;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        InputData input = new InputData();
        System.out.println("Enter the first integer.");
        Scanner keyboard = new Scanner(System.in);
        input.number1 = keyboard.nextInt();
        System.out.println("Enter the second integer.");
        input.number2 = keyboard.nextInt();
        System.out.println("Enter the third integer.");
        input.number3 = keyboard.nextInt();
        System.out.println("The average of NUMBER1, NUMBER2, and NUMBER3 = "
            + input.average());
    }
}