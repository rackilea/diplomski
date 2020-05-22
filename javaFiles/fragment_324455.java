System.out.print("Would you like to enter another patient? Type Yes or No: ");
String userInput = input.nextLine();
if (userInput.equals("Yes")) {
    while (userInput.equals("Yes")) {
        //your data entry...

        System.out.print("Would you like to enter another patient? Type Yes or No: ");
        // change userInput here, else, you're never going out of the loop.
        // so add this
        userInput = input.nextLine();
    }
} else if (userInput.equals("No")) {
    System.out.println("Goodbye");
}