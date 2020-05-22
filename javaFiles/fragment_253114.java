// User input prompt where you make the simulation. For people and return them as an array
public static int[] promptAndRead(Scanner stdIn)
{
    System.out.println("Please enter the number of simulations you want to do: ");
    int[] userInput =new int [2]; //CHANGE THIS TO 1?
    userInput[0]= stdIn.nextInt(); //my problem
    System.out.println("Please enter the size of the group you want : ");
    int[] userInput1 = new int [2]; //CHANGE THIS TO 1?
    userInput[1] = stdIn.nextInt();
    int a = userInput[1];
    while (a<2 || a>365)
    {
        System.out.println("please type the number that is between 2~365");
    }


    System.out.println();

    return(userInput);

}