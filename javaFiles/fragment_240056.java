public static void main(String[] args) {
    try (final Scanner input = new Scanner(System.in)) {

        System.out.println("Enter the name of your file (including file extension): ");
        final String filename = input.next();

        int[] numberArray = null;
        try (final Scanner in = new Scanner(new File(filename))) {
            final int count = in.nextInt();

            numberArray = new int[count];

            for (int i = 0; in.hasNextInt() && i < count; i++) {
                numberArray[i] = in.nextInt();
            }
            display(numberArray);
        } catch (final FileNotFoundException e) {
            System.out.println("That file was not found. Program terminating...");
            e.printStackTrace();
        }
    }
}