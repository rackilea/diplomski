public void _____ throws IOException {
    int number = -1;
    while (number == -1) {
        try {
            // Prompt user for line number
            // Getting number from keyboard, which could throw an exception
            number = <get from input>;
        } catch (InputMismatchException e) {
             System.out.println("That is not a number!");
        }  
    }
    // Do something with number
}