double rightNum = Math.random() *10;
int randomNum = (int) rightNum;
while (!choice.equalsIgnoreCase("n")) {
    //your logic...
    if (guess == randomNum) {
        System.out.println("Correct you've got it! The Number Was " + randomNum );
        System.out.println();
        System.out.println("Would you like to play again (y/n):");
        choice = sc.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            rightNum = Math.random() *10;
            randomNum = (int) rightNum;
        }
    }
    //your logic...
}