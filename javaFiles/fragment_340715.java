public class TollMachine 
{

static boolean running = true;  //variable to control whether the program should run
static int userInput = -1;           //variable to store the user's input
static String userInput2 = "";  //variable to store the input in case user does not enter an integer
static int motoTicketCount = 0; //variable to store the number of tickets sold(moto)
static int carTicketCount = 0;  //variable to store the number of tickets sold(car)
static int vanTicketCount = 0;  //variable to store the number of tickets sold(van)
static int truckTicketCount = 0;//variable to store the number of tickets sold(truck)
static int totalTicketCount = 0;//variable to store the number of total tickets sold
static Scanner keyb = new Scanner(System.in);   //variable to detect the user's input

public static void main(String[] args)
{

    while (userInput != 0) //runs while userInput != 0
    {

        //This is the main menu, the user is prompted to choose an option
        System.out.println("1. Motorcycle");
        System.out.println("2. Car");
        System.out.println("3. Van");
        System.out.println("4. Truck");
        System.out.println("5. Display total tickets sold.");
        System.out.println("0. Exit");

        try
        {
            /**
            THIS THROWS YOUR EXCEPTION
            **/
            if (keyb.hasNext())  
            {

                userInput = Interger.parseInt(keyb.next()); //stores the user's input to the userInput

                if (userInput >5 || userInput<0)    //if one of these conditions are true, the user selected an option
                {                                   //that is not mentioned
                    System.out.println("Invalid input.");   //displays the Invalid input error
                }
                else
                {
                    //checks which option the user chose with multiple "if" conditions
                    if (userInput == 1)
                    {

                        //Displays an appropriate message to the user, and increases the two counters by 1
                        System.out.println("Here is your motorcycle ticket.");
                        motoTicketCount++;   
                        totalTicketCount++;

                    }
                    if (userInput == 2)
                    {

                        //Displays an appropriate message to the user, and increases the two counters by 1
                        System.out.println("Here is your car ticket.");
                        carTicketCount++;
                        totalTicketCount++;

                    }
                    if (userInput == 3)
                    {

                        //Displays an appropriate message to the user, and increases the two counters by 1
                        System.out.println("Here is your van ticket.");
                        vanTicketCount++;
                        totalTicketCount++;

                    }
                    if (userInput == 4)
                    {

                        //Displays an appropriate message to the user, and increases the two counters by 1   
                        System.out.println("Here is your truck ticket.");
                        truckTicketCount++;
                        totalTicketCount++;

                    }
                    if (userInput == 5)
                    {

                        //Displays how many of each ticket were sold, and the total number of tickets sold
                        System.out.println("Motorcycle tickets sold: "+motoTicketCount);
                        System.out.println("Car tickets sold: "+carTicketCount);
                        System.out.println("Van tickets sold: "+vanTicketCount);
                        System.out.println("Truck tickets sold: "+truckTicketCount);
                        System.out.println("Total tickets sold: "+totalTicketCount);

                    }
                    if (userInput == 0)
                    {

                        running = false;    //terminates the program

                    }
                }//end of else after the if (hasNextInt())

             }//end of first if (hasNextInt())                                         

        }//end of try

        catch (NumberFormatException e)    //this SHOULD catch an invalid input error
        {
            System.out.println("Invalid input.");  //displays invalid input in case the
            userInput = -1;
        }

    }

}



}