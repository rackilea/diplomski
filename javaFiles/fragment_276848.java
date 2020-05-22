public class Average3 {
    static class InputData {
        public int[] numbers;

        InputData(int size) {
            numbers = new int[size];
        }

        public int average() {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum / numbers.length;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] prompts = { "first", "second", "third" };
        InputData input = new InputData(3);
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < prompts.length; ++i) {
            System.out.println("Enter the " + prompts[i] + " integer.");
            input.numbers[i] = keyboard.nextInt();
        }
        System.out.println("The average of NUMBER1, NUMBER2, and NUMBER3 = "
            + input.average());
    }
}