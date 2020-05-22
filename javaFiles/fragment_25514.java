private static Calculator myCalculator = null;

public static void main(String [] args)
{

        try{


            CalculatorFactory theWorks =     (CalculatorFactory)Naming.lookup("rmi://localhost:13456/CalculationsAnon");
            myCalculator = theWorks.newCalculator();

           // You rest of the code here