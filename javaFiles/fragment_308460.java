System.out.println("What is your age? : ");
if(user_input.hasNextInt()) {
    input = user_input.nextInt();
}
else {
    System.out.println("That is not an integer.");
}