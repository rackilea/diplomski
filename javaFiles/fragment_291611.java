public static void main(String args[]) {
    // let's take incoming values from the user for our calculations
    Scanner keyboard = new Scanner(System.in);

    // we'll use this array to store the values entered by the user
    // in position zero of the array we'll store the OBP
    // in positions 1-5 we'll store the inputs as entered by the uesr
    float[] values = new float[6];

    // we'll use this flag to determin if we should ask the user input again or quit the program
    boolean letsDoThisAgain = true;

    while (letsDoThisAgain){
        System.out.println("Enter a Year: ");
        int year = keyboard.nextInt();

        System.out.println("For Year " + year + ", enter number of:");
        System.out.println("Hits: ");
        values[1] = keyboard.nextFloat();

        System.out.println("Walks: ");
        values[2] = keyboard.nextFloat();

        System.out.println("Number of times player has been hit by a pitch: ");
        values[3] = keyboard.nextFloat();

        System.out.println("Number of at bats: " );
        values[4] = keyboard.nextFloat();

        System.out.println("Number of sacrifice flies: ");
        values[5] = keyboard.nextFloat();

        // calculate the OBP
        values[0] = (values[1] + values[2] + values[3] - values[5] ) / values[4]; // or however you calculate it

        System.out.println("OBP: " + values[0]);

        System.out.println("------");
        System.out.println("Do you want to do it again? (y/n): ");
        String quitOrDoItAgain = keyboard.next();

        if( "n".equalsIgnoreCase(quitOrDoItAgain)){
            letsDoThisAgain = false;
        }
    }
    System.out.println("Thanks for playing... Good Bye!");
}