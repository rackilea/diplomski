import java.util.Scanner;

public class Museum {
    static final double PRICE = 12.5;
    static final double GIFT = 8.99;

    public static void main(String[] args) {

      Scanner console = new Scanner(System.in);
      int visitors;
      double totalRevenue;

      System.out.print("Enter number of visitors: ");
      visitors = console.nextInt();

      totalRevenue = calculateRevenue(visitors);
      calculatePrintResult(visitors);

  }

  public  static double calculateRevenue(int visitors) {
      return visitors * PRICE;
  }

  public static void calculatePrintResult(int visitors) {
      System.out.println(visitors * PRICE);
  }
}