System.out.println("Type a number");
while(!input.hasNextInt()) {
    input.nextLine();
    System.out.println("That is not a valid number. Try again");
}
number = input.nextInt();