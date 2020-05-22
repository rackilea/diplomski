if (userInput.equals("yes")) {
    total += spinWheelTwice();
    if (total < 100) {
         System.out.println("You are out of the game");
    } else {
         System.out.println("Final Score is: " + total);
    }
}