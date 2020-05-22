public static int pickRow() {
        //method to let the user pick a row
        Scanner rowInput = new Scanner(System.in); 
        String response;
        int row;

        while (true) //>> loop is infinite as long as input is invalid.  As soon as it's valid, method returns, exiting the loop.
        {           
            //checks if user input is an integer by using try-catch statement
            System.out.print("Pick a row (1-5): ");
            response = rowInput.nextLine();
            try {
                row = Integer.valueOf(response);
            } catch (NumberFormatException e)
            {
                System.out.println("Sorry, invalid input. Please provide a number from 1 to 5.");
                continue;
            }

            if (!isWithinBoundaries(row))
            {    //checks if user input is within boundaries of the playing board
                System.out.println("That's outside the sea. Please provide a number from 1 to 5.");
            } else
            {                   
                row = row - 1;    //adjusts the value of row to correct for programming indices 
                return row; //>> row is valid, so return it
            }
        }
    }