Scanner input = new Scanner(System.in);
String ls = System.lineSeparator();

// We want the User to enter an inclusive number from 1 to 5.
int x = 0;
while (x < 1 || x > 5) {
    System.out.print("Enter an Integer Number from 1 to 5: --> ");
    try {
        x = input.nextInt();
        input.nextLine();   // Consume ENTER.
        System.out.println("Success! The nextInt() method accepted your input!");
        if (x < 1 || x > 5) {
            System.err.println("But...this application does not accept it!");
            System.err.println("We asked for a number from 1 to 5! Try again..." + ls);
        }
    }
    catch (InputMismatchException  ex) {
        System.out.println(ex.getMessage());
        System.err.println("Invalid Input! An Integer number from 1 to 5 only!" + ls);

        //BTW am I correct in thinking the following clears the buffer?
        /* YES you are since the nextInt() method does not consume the
           the newline character provided by the ENTER key like the nextLine()
           method does and therefore provides it on the next input request
           which in this case ultimately generates an endless loop of exceptions.
           Even if this prompt was successful and control is passed on to the 
           next prompt and if that prompt was a nextLine() method then it would 
           be basically skipped over because it would then consume that ENTER 
           key newline character provided in the last nextInt() method.  So
           with that in mind, it doesn't hurt to place input.nextline(); 
           directly after the x = input.nextInt(); ether.               */
        input.nextLine();   // Consume ENTER.
    }
}
System.out.println(x + " Was Supplied! - DONE!");