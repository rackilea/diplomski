public static String giveInput() {

    Scanner in = new Scanner(System.in);
    String inputString;
    int inputNumber = 0;

    do {
        System.out.println("Enter numerical value between 1 and 20");
        inputString = in.nextLine();
        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.err.println("Please enter a number");
        }

    } while (inputNumber < 1 || inputNumber > 20);

    return inputString;
}