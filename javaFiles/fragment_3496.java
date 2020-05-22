import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    menu();
  }

  public static void menu() {
    Scanner scan = new Scanner(System.in);
    boolean works = true;
    do {
      System.out.println(
          "\n1 - Register Car\t2 - Register Client\t3 - Rent car\n4 - Returning car\t5 - Show list\t6 - Exit\n");
      System.out.print("Input: ");
      int operacao = scan.nextInt();
      if (operacao == 1) {
        System.out.println("cadVeiculo();");
      } else if (operacao == 2) {
        System.out.println("cadCliente();");
      } else if (operacao == 3) {
        System.out.println("locar();");
      } else if (operacao == 4) {
        System.out.println("devolver();");
      } else if (operacao == 5) {
        System.out.println("listar();");
      } else if (operacao == 6) {
        System.out.println("Goodbye!");
        works = false;
      }
    } while (works);
    scan.close();
  }
}