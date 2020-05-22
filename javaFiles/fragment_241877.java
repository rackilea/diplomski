public class Main {
  public static void acceptValidInput(Scanner sc) {
    System.out.print("Enter a number greater than 10: ");

    int i = sc.nextInt();

    if (i <= 10) {
      acceptValidInput(sc);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    acceptValidInput(sc);
    System.out.println("Your input is valid");
    sc.close();
  }
}