public class Swap
{
  public static void main(String[] args)
  {
      String[] myStringArray = {"1","2"};
      swapNum(myStringArray);
  }

  public static void swapNum(String[] args){
     int num1 = Integer.parseInt(args[0]);
      int num2 = Integer.parseInt(args[1]);
      System.out.println("\n***Before Swapping***");
      System.out.println("Number 1 : "+num1);
      System.out.println("Number 2 : "+num2);
      //Swap logic
      num1 = num1 + num2;
      num2 = num1 - num2;
      num1 = num1 - num2;
      System.out.println("\n***After Swapping***");
      System.out.println("Number 1 : "+num1);
      System.out.println("Number 2 : "+num2);
  }


}