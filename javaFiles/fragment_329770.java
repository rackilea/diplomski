public static void main(String[] args) throws Exception {
    // Create a Scanner object for keyboard input.
    Scanner input = new Scanner(System.in);

    // You can provide file object or just file name either would work.
    // If you are going for file name there is no need to create file object
    FileWriter outputfile = new FileWriter("namef.txt");
    System.out.print("Enter the number of data (N) you want to store in the file: ");

    int N = input.nextInt(); // numbers from the user through keyboard.
    System.out.println("Enter " + N + " numbers below: ");
    for (int i = 1; i <= N; i++) {
        System.out.print("Enter the number into the file: ");
        // Writing the value that nextInt() returned.
        // Doc: Scans the next token of the input as an int.
        outputfile.write(Integer.toString(input.nextInt()) + "\n");
    }
    System.out.println("Data entered into the file.");
    input.close();
    outputfile.close(); // Close the file.
}