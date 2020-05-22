public static void main(String[] args)    
    {//Start main method
        int stations; 
        keyboard2 = new Scanner(System.in);

        System.out.print("Welcome to Gas Station \n");
        System.out.println("Choose Station Number: \n");
        System.out.println("1, 2, or 3 \n");

        stations = keyboard2.nextInt(2);


        switch (stations)
        {
            case 1:
            System.out.println("You entered Station 1.");
            break;


            case 2:
            System.out.println("You entered Station 2.");
            break; 

            case 3:
            System.out.println("You entered Station 3.");
            break;

            default:
            System.out.println("Error: Invalid Number"); 
       }//End Switch
    }//End Main Method

    private Scanner keyboard;
    {
        //Snip 1
    }

    private Scanner keyboard1;
    {
        //Snip 1
    }
    //Marker 2
    double totalPayment = 0.0;
    double numberGallons = 0;
    double Unleaded = 0;
    double UnleadedPlus = 0;
    double UnleadedPremium = 0;
    double tax = 0;
    private static Scanner keyboard2;
    {
        //Snip 1
    }
}//Class End