import java.util.Scanner;

public class BarkingLot {
  public static void main(String[] args) {
    Scanner Scanner = new Scanner(System.in);
    int x = 20;
    int y = 25;
    int Large = 0;
    int Small;
    int quit = 0;

    while (quit == 0){
     System.out.println("Enter number of large dogs: ");
    Large = Scanner.nextInt();
    // need to initialize Small here.
    Small = (8 - Large);

    int Revenue = ((Small * x) + (Large * y));
    int Food = ((Small + Large) * (2));
    int Facility = 30;
    int Expenses = (Food + Facility);
    int Difference = (Revenue - Expenses);

    if ((Small + Large) <= 8) {
      System.out.println("Revenue is " + ((Small * x) + (Large * y)));
      System.out.println("Expenses = " + (Food + Facility));
      System.out.println("Difference = " + (Revenue - Expenses));

    } else
      System.out.println("The number of dogs has exceeded the facility limit.");
  }
}
}