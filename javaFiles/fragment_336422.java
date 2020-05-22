public static void main(String[] args)
{ 
    Scanner kb = new Scanner(System.in);
    String aaa = "y";

    while(aaa.equalsIgnoreCase("y"))
    {
        System.out.println("Bet ? : ");
        int bet = kb.nextInt(); // Read the Integer
        aaa = kb.nextLine(); // Read the "\n"

        for (int i = 1; i <= 3; i++)
        {

        }

        System.out.print("Would you like to play again(enter y or n): ");
        aaa = kb.nextLine();
        if (aaa.equalsIgnoreCase("n"))
        {
            System.out.println("Goodbye !");
            System.exit(0); 
        }
    }
}