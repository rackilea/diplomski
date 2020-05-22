// reads the player's lottery ticket from the console
public static Set<Integer> getTicket()
{
    Set<Integer> ticket = new TreeSet<>();
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter " + NUMBERS + " unique lotto numbers!");

    int validInputs = 0;
    while (input.hasNextInt() && validInputs < NUMBERS)
    {
        System.out.printf("Enter number %d: ", validInputs);
        int getTicket = input.nextInt();
        if (getTicket< MIN_NUMBER || getTicket > MAX_NUMBER)
        {
            //prints out if number is not within the lotto range
            System.out.println("Your number must be in " +
                MIN_NUMBER + " - " + MAX_NUMBER + " range.");
        }
        else
        {
            if (ticket.add(getTicket))
            {
                //prints out if number successfully added
                System.out.println("Number added successfully");
                validInputs++; // Increment valid inputs here
            }       
            else
            {
                // prints out if number is not successfully added.
                System.out.println("Duplicate number detected");
            }
        }
    }
}