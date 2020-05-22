import java.text.DecimalFormat;
import java.util.Scanner;

class YourClassName
{
    public static void main(String[] args)
    {
        boolean askAgain = true;

        while (askAgain)
        {
            Scanner input = new Scanner(System.in);

            System.out.println(
                    " Welcome to the money exchange! \n Please pick one of the currencies by useing 1 / 2 / 3 \n \n 1 = US dollar \n 2 = GB pounds \n 3 = Yen \n  ");
            System.out.print("Input : ");

            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);

            int choice = input.nextInt();
            double transfee = 2.41;
            double USrate = 0.9083;
            double GBrate = 1.4015;
            double YENrate = 0.0075;

            if (choice > 3 || choice < 1)
            {
                System.out.println("Invalid input!...... Please try agian\n");
            } else
            {
                if (choice == 1)
                {
                    System.out.println("You have choosen for US dollar \n");
                    System.out.print("Please enter amount US dollar: ");
                    double USamount = input.nextDouble();
                    double deuros = USamount * USrate;
                    double ddisburse = deuros - transfee;

                    System.out.print(
                            "\nInput amount US dollar:. " + USamount + "\n");
                    System.out.print("Worth in euro's:........ "
                            + df.format(deuros) + "\n");
                    System.out.print(
                            "Transfer cost:.......... " + transfee + "\n");
                    System.out.print("Amount to disburse:..... "
                            + df.format(ddisburse) + "\n");

                } else
                {
                    if (choice == 2)
                    {
                        System.out.println("You have choosen for GB pounds");
                        System.out.print("Please enter amount GB ponds: ");
                        double GBamount = input.nextDouble();
                        double geuros = GBamount * GBrate;
                        double gdisburse = geuros - transfee;

                        System.out.print(
                                "\nInput amount GB pound:. " + GBamount + "\n");
                        System.out.print("Worth in euro's........ "
                                + df.format(geuros) + "\n");
                        System.out.print(
                                "Transfer cost:......... " + transfee + "\n");
                        System.out.print("Amount to disburse:.... "
                                + df.format(gdisburse) + "\n");

                    } else
                    {
                        if (choice == 3)
                        {
                            System.out.println("You have choosen for Yen");
                            System.out.print("Please enter amount Yen: ");
                            double YENamount = input.nextDouble();
                            double yeuros = YENamount * YENrate;
                            double ydisburse = yeuros - transfee;

                            System.out.print("\nInput amount Yen:... "
                                    + YENamount + "\n");
                            System.out.print("Worth in euro's..... "
                                    + df.format(yeuros) + "\n");
                            System.out.print(
                                    "Transfer cost:...... " + transfee + "\n");
                            System.out.print("Amount to disburse:. "
                                    + df.format(ydisburse) + "\n");

                        }
                    }
                }
            }

            System.out.println("Do you want to do another calculation? (y/n)");
            String againAnswer = input.next();
            askAgain = againAnswer.equalsIgnoreCase("y");
        }
    }
}