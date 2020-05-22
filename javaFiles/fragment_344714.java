public static void main (String[] args)
    {
        Scanner keyboard = new Scanner (System.in);
        DecimalFormat formatter = new DecimalFormat("%#,##0.00");
        int numFloors = 0;
        int numRooms = 0;
        int totalRooms = 0;
        int numOccupied = 0;
        int totalOccupied = 0;
        int percentOccupied = 0;

        System.out.println("Please enter the number of floors in the hotel: ");
        numFloors = keyboard.nextInt();

        while (numFloors <1)
        {
            System.out.println("You have entered an invalid number of floors. ");
            System.out.println("Please enter the number of floors in the hotel: ");
            numFloors = keyboard.nextInt();
        }

        for (int counter = 1; counter <=numFloors; counter++)
        {
            System.out.println("Please enter the number of rooms on floor #: " + counter);
            numRooms=keyboard.nextInt();
            //REMOVE totalRooms += numRooms; from here

            while (numRooms <10)
            {
                System.out.println("You have entered an invalid number of rooms. ");
                System.out.println("Please enter the number of rooms on floor #: " + counter);
                numRooms = keyboard.nextInt();
            }
            totalRooms += numRooms;  //ADD it here

            System.out.println("Please enter the number of occupied rooms on floor #: " + counter);
            numOccupied = keyboard.nextInt();
            totalOccupied += numOccupied;
            // *not sure of how to do this* percentOccupied = totalOccupied/totalRooms;
        }

        System.out.println("The hotel has a total of " + totalRooms + " rooms.");
        System.out.println(totalOccupied + " of the rooms are occupied.");
        System.out.println (percentOccupied + "% of the rooms are occupied.");
    }