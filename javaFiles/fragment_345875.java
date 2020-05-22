public static void main(String[]args) {
    String parkingspace[][] = new String[3][3];

    // Make these variables to be consistent
    final String empty    = "EMPTY";
    final String reserved = "RSRVD";

    // Initialize
    for (int floor = 0; floor < parkingspace.length; floor++) {
        for (int lot = 0; lot < parkingspace[floor].length; lot++) {
            parkingspace[floor][lot] = empty;
        }
    }
    Scanner scan = new Scanner(System.in);
    while (true) {
        // Print the parking lot
        for (int floor = 0; floor < parkingspace.length; floor++) {
            System.out.print("Floor " + floor + ": "); 
            for (int lot = 0; lot < parkingspace[floor].length; lot++) {
                System.out.print("Lot #" + lot + ":  [" + parkingspace[floor][lot] + "]   ");
            }
            System.out.println();
        }

        // Get user input
        System.out.println("Are you leaving(0) or parking(1)?");
        int input = scan.nextInt();
        System.out.println("Which floor (0, 1, 2)?");
        int floor = scan.nextInt();
        System.out.println("Which lot (0, 1, 2)?");
        int lot = scan.nextInt();

        // Update parking lot
        if (input == 1 && parkingspace[floor][lot].equals(empty)) {
            parkingspace[floor][lot] = reserved;
        }
        else if (input == 0 && parkingspace[floor][lot].equals(reserved)) {
            parkingspace[floor][lot] = empty;
        }
    }
}