import java.util.Scanner;
import java.util.UUID;

public class AccountThis {

  private static Scanner scanner;


  public AccountThis(String nameInput) {

    System.out.println(" created account with name " + nameInput);
  }

  public AccountThis() {
    System.out.println("created an account.");
  }

  public AccountThis(double depositInput) {

    System.out.println(depositInput + "$" + "added to your account!");
  }

  public AccountThis(String nameInput, double depositInput, String id) {
    System.out.println(" created account with \n ID : " + id + ", \n name : " + nameInput);
    System.out.println(depositInput + "$" + "added to your account!");
  }

  public static void main(String[] args) {
    //name input
    scanner = new Scanner(System.in);
    System.out.print("Type your name: ");
    String nameInput = scanner.nextLine();
    System.out.println("Hello" + " " + nameInput);

    //deposit input
    scanner = new Scanner(System.in);
    System.out.print("Type how much you want to deposit:");
    double depositInput = scanner.nextDouble();
    System.out.println("you want to deposit" + " " + depositInput + "$");

    UUID randID = UUID.randomUUID();
    String id=randID.toString();

    new AccountThis(nameInput, depositInput,id);
  }
}