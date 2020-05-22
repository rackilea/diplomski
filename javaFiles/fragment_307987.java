int userInput;
    while(true) {    
        try {
            System.out.println("Please enter a number: ");
            Scanner input = new Scanner(System.in);
            userInput = input.nextInt();
            break;
        }
        catch(InputMismatchException | NumberFormatException ex ) {
            System.out.println("Invalid Number, Please try again");
        }
    }