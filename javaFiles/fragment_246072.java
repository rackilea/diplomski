public class SalesByQuarter
{
    public static void main(String[] args)
    {
        int divs = 6; 
        int qtrs = 4; 
        double totalSales = 0.0;  
        double errorCheck;

    double[][] sales = new double[divs][qtrs];


    Scanner keyboard = new Scanner(System.in);


    System.out.println("This program will calculate the " +
                       "total sales of");
    System.out.println("all the company's divisions. " +
                       "Enter the following sales data:");

    System.out.println();


        for (int div = 0; div < divs; div++)
        {
            for (int qtr = 0; qtr < qtrs; qtr++)
            {
                System.out.printf("Division %d, Quarter %d: $",
                                (div + 1), (qtr + 1));
                errorCheck = keyboard.nextDouble();
                while(errorCheck<0) {
                    System.out.println("Positive numbers only please!");
                    System.out.printf("Division %d, Quarter %d: $",
                                (div + 1), (qtr + 1));
                    errorCheck = keyboard.nextDouble();
                }
                sales[div][qtr] = errorCheck;
            }
            System.out.println();
        }





        for (int div = 0; div < divs; div++)
        {
            for (int qtr = 0; qtr < qtrs; qtr++)
            {
                totalSales += sales[div][qtr];
            }
        }


        double[] divsales = new double[divs];


        for (int div = 0; div < divs; div++)
        {
            for (int qtr = 0; qtr < qtrs; qtr++)
            {
                divsales[div] += sales[div][qtr];
            }
            System.out.printf("Division %d sales: $%,.2f\n", (div + 1), divsales[div]);
        }


        System.out.println();


        for (int div = 1; div < divs; div++)
        {
            if ((divsales[div] - divsales[div - 1]) > 0)
            {
                System.out.printf("Division %d increase over its previous quarter: $%,.2f\n", (div + 1), divsales[div] - divsales[(div - 1)]);
            }
            else if ((divsales[div] - divsales[div - 1]) < 0)
            {
                System.out.printf("Division %d decrease from its previous quarter: $%,.2f\n", (div + 1), divsales[div] - divsales[(div - 1)]);
            }
            else
            {
                System.out.printf("Division %d had no increase or decrease from its previous quarter.\n", (div + 1));
            }
        }


        System.out.println();


        double[] qtrsales = new double[qtrs];


        for (int div = 0; div < divs; div++)
        {
            for (int qtr = 0; qtr < qtrs; qtr++)
            {
                qtrsales[qtr] += sales[div][qtr];
            }
        }




        for (int qtr = 0; qtr < qtrs; qtr++)
        {
            System.out.printf("Total sales for quarter: %d: $%,.2f\n", (qtr + 1), qtrsales[qtr]);
        }


        System.out.println();


        for (int qtr = 0; qtr < qtrs; qtr++)
        {
            System.out.printf(" Average sale for quarter: %d: $%,.2f\n", (qtr + 1), (qtrsales[qtr] / divs));
        }


        System.out.println();


        int highestDiv = 0;
        int[] highestDivi = new int[qtrs];
        for (int qtr = 0; qtr < qtrs; qtr++)
        {
            highestDiv = 0;
            for (int div = 0; div < (divs - 1); div++)
            {
                if (sales[highestDiv][qtr] < sales[(div + 1)][qtr])
                {
                    highestDiv = (div + 1);
                }
            }
            highestDivi[qtr] = highestDiv;
        }

        for (int qtr = 0; qtr < qtrs; qtr++)
        {
            System.out.printf("Division %d had the highest sales in quarter %d\n", qtr + 1, highestDivi[qtr] + 1);
        }

    }

}