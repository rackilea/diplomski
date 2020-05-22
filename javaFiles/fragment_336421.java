public static void main(String[] args)
{ 
    Scanner kb = new Scanner(System.in);
    String aaa = "y";

    while(aaa.equalsIgnoreCase("y"))
    {
        System.out.println("Bet ? : ");
        int bet = kb.nextInt();

        for (int i = 1; i <= 3; i++)
        {
            if (i == 3) 
            {
                System.out.print("Would you like to play again(enter y or n): ");
            }
            System.out.println("I read a line !");
            aaa = kb.nextLine();
            if (aaa.equalsIgnoreCase("n"))
            {
                System.out.println("Goodbye !");
                System.exit(0); 
            }
        }
    }
}