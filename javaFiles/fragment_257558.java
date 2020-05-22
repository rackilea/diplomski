public class Fractions
{
    public static void main(String[] args)
    {
        // -----declare variables-----
        int numOfFractions = 0, numerator = 0;
        double total = 0;
        DecimalFormat df1 = new DecimalFormat("#0.##");
        Scanner stdIn = new Scanner(System.in);

        // ----Welcome MSG------
        System.out.println("");
        System.out.println("\t* * * Welcome to Fractions * * * ");
        System.out.println("");

        // -----get numOfFractions------
        System.out.print("Enter the number of fractions: ");
        numOfFractions = stdIn.nextInt();

        // ----begin loop-------
        numerator = 1;

        while (numerator <= numOfFractions)
        {

            while (numOfFractions > 0)
            {
                if (numOfFractions > 1)
                {
                    System.out.print("" + numerator + "/" + numOfFractions + " " + "+" + " ");
                }
                else
                {
                    System.out.print("" + numerator + "/" + numOfFractions + " ");
                }

                total += (double) numerator / numOfFractions;
                numOfFractions--;
                numerator++;
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.print("The total: " + df1.format(total));
        System.out.println("");
        System.out.println("\nThanks for using the Fraction Adder program\n");

    } // end main
} // end pgm