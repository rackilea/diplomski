Scanner scan = new Scanner(System.in);

boolean validInput = false;
int val = 0;

while(!validInput) {
    try {
        val = scan.nextInt();
        validInput = true;
    } catch(InputMismatchException e) {
        System.out.println("Please enter an integer!");
        scan.next();
    }
}

System.out.println("You entered: " + val);