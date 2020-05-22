Scanner option = new Scanner(System.in);

while (!option.hasNextInt()) {
    System.out.println("Bad input"); // print an error message
    option.nextLine(); // clear bad input
}
int userInput = option.nextInt();
if (userInput == 1) {
    // ...
}