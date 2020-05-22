try {
    String userInput = input.nextLine();
    // If user input is 'q', quit program.
    if (userInput.equalsIgnoreCase("q")) {
        System.out.println("Exiting...");
        System.exit(0);
    } else {

        int userAnswer = Integer.parseInt(userInput);
        int answer = randInt1 * randInt2;
        // Checks if the users input is correct.
        if (answer == userAnswer) {
            System.out.println("That is correct!");
            correctAnswers++;
        } else {
            System.out.println("That is incorrect! " + "The correct answer should be " + answer);
            counter++;
        }
    }

} catch (NumberFormatException e) {
    System.out.println(
        "You have entered something other than an integer or 'q'! Please try again with a different question!");

}