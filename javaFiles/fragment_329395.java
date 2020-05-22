public static void menudisplayer() {

    Scanner myObj = new Scanner(System.in);

    for (int i=0; i<7; i++) 
        System.out.println("1 - Add" + "\n" + "2  - Subtract" + "\n" + "3 - Divide " + "\n" + "4 - Multiply" + "\n" + "5 - Average" + "\n" + "6 - Maximum"); //printing men

    System.out.println("Please type in the operation that you would like to use");
    String operations = myObj.nextLine(); // Read user input
    System.out.println("You Entered: " + operations + "\n"); // Output user input

   // all your ifs

}