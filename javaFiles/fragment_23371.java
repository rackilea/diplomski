public String takeInput(Scanner input, String label) {

    while (true) {
       try {
            System.out.print(label + ": ");
            return input.next();               
         } catch (InputMismatchException e) {
            System.out.println("bad input, try again");    
            input.next();             
         }
    }
}