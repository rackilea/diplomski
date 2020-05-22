public static int player() {
    int total = 0;
    Scanner inputScanner = new Scanner(System.in);
    String userInput = inputScanner.nextLine();
    if (userInput.equals("yes")) {
        total += spinWheel();
        if (total < 100) {
            System.out.println("Would you like to spin again?");
            userInput = inputScanner.nextLine();
            if (userInput.equals("yes")) {
                total += spinWheelTwice();
                if (total < 100) {
                    System.out.println("You are out of the game");
                } else {
                    System.out.println("Final Score is: " + total);
                }
            } else {
                System.out.println("You are out of the game");
            }
        }
    }
    return total;
}