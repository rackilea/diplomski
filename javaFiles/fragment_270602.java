import java.util.Scanner;
    public class MoneyMakerRecursion {
        public static int counter = 0;
        public static double investment = 0;
        public static void main(String[] args) {
            //Variables declared
            Scanner userInput = new Scanner(System.in);
            //User is prompted for input
            System.out.println("Enter your monthly investment: ");
            investment = userInput.nextInt();
            //Method is called
            Sum(investment);
            //Results from recursive method output 
            System.out.println("It should take " + counter + " month(s) to reach your goal of $10,000,000");
        }
        //recursive Method
        public static double Sum(double totalInvestment) {
            counter++;
            double total = (totalInvestment* 0.02) + totalInvestment;
            if(total >= 10000000) {return counter;}
            else {return Sum(total+investment);}
        }
    }