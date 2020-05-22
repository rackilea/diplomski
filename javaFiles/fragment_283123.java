public class TipCalc
  {
    public static void main(String[] args)
    {
      Scanner cin = new Scanner(System.in);
      System.out.println("Tip Calculator");
      System.out.println("===============");
      System.out.print("Enter check subtotal (9.25): ");
      double subtotal = cin.nextDouble();
      System.out.print("Enter gratuity percentage (20): ");
      int gratuity = cin.nextInt();
      System.out.println("");
      double gratuityAmount = gratuity * .01 * subTotal; //Note: subTotal variable isn't defined
      System.out.println("\tGratuity: " + gratuityAmount);
      double total = gratuityAmount + subTotal;
      System.out.println("\tTotal: $" + total);
    }
  }