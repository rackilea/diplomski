System.out.print("Would you like to enter another patient? Type Yes or No: ");
String userInput = input.nextLine();
while (userInput.equals("Yes")) {
    //your data entry...

    System.out.print("Would you like to enter another patient? Type Yes or No: ");
    userInput = input.nextLine();
}

System.out.println("Goodbye");