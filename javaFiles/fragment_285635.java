import java.text.DecimalFormat;
import java.util.Scanner;
public class Coffee {
    public static void main(String args[]){
        Scanner bags = new Scanner(System.in);
        System.out.println("Hello and welcome to the program");
        System.out.println("Here is the discount list for the IT125 Coffee Company");
        System.out.println("<= 24 Bags      No discount");
        System.out.println(">= 25 Bags      5% ");
        System.out.println(">= 50 Bags      10% ");
        System.out.println(">= 100 Bags     15% ");
        System.out.println(">= 150 Bags     20% ");
        System.out.println(">= 200 Bags     25% ");
        System.out.println(">= 300 Bags     30% ");
        System.out.println("");

        DecimalFormat df = new DecimalFormat("0.00");
        int num1;
        System.out.print("Enter the number of bags purchased: ");
        num1 = bags.nextInt();
        System.out.println("Bags purchased " + num1);
        double cost, disc, totcost;
        totcost = 0;
        disc = 0;
        cost = num1 * 5.50;
        System.out.println("Normal Price: € " + df.format(cost));



        if (num1 < 25) {
            System.out.println("Your dicount is " + disc);
            totcost = cost - disc;
            System.out.print("Your total cost is € " + df.format(totcost));
        }

        else if (num1 >= 25 && num1<50) {
            disc = cost * 0.05;
            totcost = cost - disc;
            System.out.println("Your dicount is € " + df.format(disc));
            System.out.print("Your total cost is € " + df.format(totcost));
        }

        else if (num1 >= 50 && num1<100) {
            disc = cost * 0.1;
            totcost = cost - disc;
            System.out.println("Your dicount is € " + df.format(disc));
            System.out.print("Your total cost is € " + df.format(totcost));
        }

        else if (num1 >= 100 && num1<150) {
            disc = cost * 0.15;
            totcost = cost - disc;
            System.out.println("Your dicount is € " + df.format(disc));
            System.out.print("Your total cost is € " + df.format(totcost));
        }

        else if (num1 >= 150 && num1<200) {
            disc = cost * 0.2;
            totcost = cost - disc;
            System.out.println("Your dicount is € " + df.format(disc));
            System.out.print("Your total cost is € " + df.format(totcost));
        }

        else if (num1 >= 200 && num1<300) {
            disc = cost * 0.25;
            totcost = cost - disc;
            System.out.println("Your dicount is € " + df.format(disc));
            System.out.print("Your total cost is € " + df.format(totcost));

        }

        else if (num1 >= 300) {
            disc = cost * 0.3;
            totcost = cost - disc;
            System.out.println("Your dicount is € " + df.format(disc));
            System.out.print("Your total cost is € " + df.format(totcost));
        }

    }

}