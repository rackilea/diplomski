import java.util.Scanner;

public class ClientTest {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      Client[] clients = new Client[5];

      for (int i = 0; i < clients.length; i++) {
         System.out.print("Enter Client Number: ");
         String clientNumber = scanner.nextLine();
         System.out.print("Enter Client Name: ");
         String name = scanner.nextLine();

         clients[i] = new Client(clientNumber, name);
      }

      scanner.close();

      for (Client client : clients) {
         System.out.println(client);
      }
   }
}