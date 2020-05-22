Scanner userInput = new Scanner(System.in);
int userAnswer;
int totalScore = 0;

System.out.print("Q1.) Who is the main character in the Legend of Zelda?\n"
        + "1.) Link\n2.) Princess Zelda\n3.)Super Mario"
        + "\nAnswer: ");
userAnswer = userInput.nextInt();
if (userAnswer == 1){
    System.out.print("That is correct! ");
    totalScore = totalScore + 1;  // or totalScore++
}
else {
    System.out.print("I'm sorry but that is wrong.");
}

System.out.print("\nQ2.) Who is the main character in the Naruto?\n"
        + "1.) Sasuke\n2.) Naruto\n3.) Sakura"
        + "\nAnswer: ");
userAnswer = userInput.nextInt();
if (userAnswer == 2){
    System.out.print("That is correct! ");
    totalScore = totalScore + 1;  // or totalScore++
}
else {
    System.out.print("I'm sorry but that is wrong.");
}

System.out.print("Q3.) Who is the main character in the Dragon Balls??\n"
        + "1.) Krillin\n2.) Bulma\n3.) Goku"
        + "\nAnswer: ");
userAnswer = userInput.nextInt();
if (userAnswer == 3){
    System.out.print("That is correct! ");
    totalScore = totalScore + 1;  // or totalScore++
}
else {
    System.out.print("I'm sorry but that is wrong.");
}

System.out.print("your total score is " + totalScore);