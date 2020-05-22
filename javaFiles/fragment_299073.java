Scanner scan = new Scanner(System.in);//Create the scanner object 
boolean running = true; //Create a boolean "flag" for the while loop. 
int answer = 0; //Initial answer set to 0

while(running) { //program "flag". Should run so long as running == true
        System.out.println("Welcome to the math questions game!");
        int num1 = (int)(Math.random() * 100) + 1; //Create a random number for first num
        int num2 = (int)(Math.random() * 100) + 1; //Create a random number for second num
        int correctAnswer = num1 * num2; //Get the correct answer
        System.out.println("What is " + num1 + " * " + num2); //Display question
        answer = scan.nextInt();  //Scanner will pick up users answer
        if(answer == correctAnswer) { //if the question matches the correct answer, print congrats and continue with the loop.
            System.out.println("Congrats! That is correct");
        }
        else if(answer != correctAnswer) { //If the answer does not match, while the answer is incorrect, continue to prompt the user for the correct answer. 
            while(answer != correctAnswer) {
                System.out.println("Incorrect! Try again.");
                System.out.println("What is " + num1 + " * " + num2);
                answer = scan.nextInt();
            }
        }
        System.out.println("Would you like to play again? Yes to play again, No to exit: ");
        String keepPlaying = scan.next();
        if(keepPlaying.equalsIgnoreCase("No")) {
            running = false;
        }
    }