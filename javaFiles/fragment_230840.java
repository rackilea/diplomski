public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    double mainNumber = 0;
    boolean isValidNumber = false;

    System.out.print("Enter a number: ");
    while (isValidNumber == false) {
        String line = scnr.nextLine();
        try {
            mainNumber = Double.valueOf(line);
            isValidNumber = true;
        } catch (NumberFormatException e){
            System.out.print("Sorry, please enter a number.\n");
        }
    }

    System.out.println("Main number is: " + mainNumber);
}