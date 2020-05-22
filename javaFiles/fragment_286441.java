import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {  
  public static List<Customer> getCustomers(String filename, String delimiters) {
    List<Customer> customers = new ArrayList<Customer>();
    Customer customer = null;
    File file = new File(filename);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if ((customer = createCustomer(line, delimiters)) != null)
          customers.add(customer);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      scanner.close();
    }

    return customers;
  }

  public static Customer createCustomer(String line, String delimiter) {
    String[] arr = line.split(delimiter);
    if (arr.length < 3)
      return null;
    int id = Integer.parseInt(arr[0].trim());
    String name = arr[1].trim();
    float balance = Float.parseFloat(arr[2].trim());
    return new Customer(id, name, balance);
  }
}