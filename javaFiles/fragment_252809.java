//Question 1
System.out.println("Who holds the world record for running the fastest 100 meter dash?");

String questionOne;
questionOne = scan.nextLine();

if(questionOne.equalsIgnoreCase("Usain Bolt")) {
    System.out.println("Correct!");
    correctCount++; //here you increase the variable by one.
}
else 
    System.out.println("Incorrect. The answer was: Usain Bolt");
    System.out.println("Next Question");

    try {
        Thread.sleep(2000);
        }catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }