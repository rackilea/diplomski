boolean validInput = false;
do {
    try {
        System.out.println("Enter your first number");
        i1 = scan.nextDouble();
        validInput = true;
    } catch(Exception e) {
        System.out.println("You must enter a number");
        validInput = false;
    }
} while(!validInput);
validInput = false;
// Second loop to follow using validInput instead of w2