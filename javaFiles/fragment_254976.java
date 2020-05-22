import java.io.*; 

public class Nums { 
  public static void main(String args[])  
    throws IOException 
  { 
    BufferedReader br = new BufferedReader(new 
                            InputStreamReader(System.in)); 
    String str;
    int EnteredNumbers = -1;
    int Positive = 0;
    int Negative = 0;
    int NegativeSum = 0;
    int PositiveSum = 0; // Added extra variable
    double AveragePositive = 0;

    System.out.println("Enter '0' to quit."); 
    System.out.println("Enter Numbers: "); 
   try{
    do { 
      EnteredNumbers++;
      str = br.readLine();

    int num = Integer.parseInt(str);


    if (num>0)
      {
        Positive++;
        PositiveSum+=num;
      }
      else if (num<0)
      {
        Negative++;
        NegativeSum+=num;
      }
    } while(!str.equals("0")); 
    AveragePositive = (double)PositiveSum/(double)Positive;
      System.out.println("You have have entered "+EnteredNumbers+ " numbers!");
      System.out.println("You have have entered "+Positive+ " Positive numbers!");
      System.out.println("The Average of the Positive Numebers is "+AveragePositive+ "!");
      System.out.println("You have have entered "+Negative+ " Negative numbers!");
      System.out.println("The Sum of the Negative numbers is "+NegativeSum+ "!");
    }
    catch (java.lang.NumberFormatException e)
    {
        System.out.println("Wrong format");
    }  

} 
}