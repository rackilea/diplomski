while (true) {
    System.out.print("Pick a number 1-10: ");
    int number = input.nextInt();
    if (number == random) {
        System.out.println("Good!");
        break; // This ends the loop
    } else if (number > random) {
        System.out.println("Too Big");
    } else if (number < random) {
        System.out.println("Too Small");
    }
}