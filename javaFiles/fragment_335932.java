Scanner scanner;
while(true) {    
    try {
        System.out.println("Please enter a number: ");
        scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(input);
        //statements
        break;
    }
    catch(InputMismatchException | NumberFormatException ex ) {
        System.out.println("I said a number...");
    }
}