import java.util.*;
import java.text;

class PiggyBank
{
 Scanner console = new Scanner(System.in);
 NumberFormat formatter = NumberFormat.getCurrencyInstance();

 private int numPennies, numNickles, numDimes, numQuarters;
 private float total;

 public PiggyBank(int pennies, int nickles, int dimes, int quarters)
{
   numPennies = pennies;
   numNickles = nickles;
   numDimes = dimes;
   numQuarters = quarters;     
   total = 0.00;
}