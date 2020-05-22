public static void main(String[] args) {
    try (final Scanner input = new Scanner(System.in)) {
        final int[] numberArray = new int[10];

        System.out.println("Enter the name of your file (including file extension): ");
        final String filename = input.next();

        try (final Scanner in = new Scanner(new File(filename))) {
            final int count = in.nextInt();
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