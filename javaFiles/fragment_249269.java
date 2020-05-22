static double doubleFromUser(Scanner sc, String prompt, String description){
    while(true) { //until there is a successful input
        try {
            System.out.print(prompt); //move to before the loop if you do not want this repeated
            return sc.nextDouble();
        } catch (InputMismatchException e1) {
            System.out.println("Please enter a valid number for the " + description);
        }
    }
}