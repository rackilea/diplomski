import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static bank.Utils.getCustomers;

public class Bank {
  protected List<Customer> customers;

  public enum Sort {
    ID, NAME, BALANCE
  }

  public Bank() {
    String filename = "bank/Bank.txt";
    String delimiters = "[,]";
    customers = getCustomers(filename, delimiters);

    printCustomers(Sort.ID, false);
    printCustomers(Sort.ID, true);
    printCustomers(Sort.NAME, false);
    printCustomers(Sort.NAME, true);
    printCustomers(Sort.BALANCE, false);
    printCustomers(Sort.BALANCE, true);
  }

  public void sortId(boolean descending) {
    final int d = descending ? -1 : 1;
    Comparator<Customer> comparator = new Comparator<Customer>() {
      public int compare(Customer c1, Customer c2) {
        return (c1.id() > c2.id() ? 1 :
               c1.id() == c2.id() ? 0 : -1) * d;
      }
    };
    Collections.sort(customers, comparator);
  }

  public void sortName(boolean descending) {
    final int d = descending ? -1 : 1;
    Comparator<Customer> comparator = new Comparator<Customer>() {
      public int compare(Customer c1, Customer c2) {
        return (c1.name().compareTo(c2.name())) * d;
      }
    };
    Collections.sort(customers, comparator);
  }

  public void sortBalance(boolean descending) {
    final int d = descending ? -1 : 1;
    Comparator<Customer> comparator = new Comparator<Customer>() {
      public int compare(Customer c1, Customer c2) {
        return (c1.balance() > c2.balance() ? 1 :
               c1.balance() == c2.balance() ? 0 : -1) * d;
      }
    };
    Collections.sort(customers, comparator);
  }

  public void printCustomers(Sort sortBy, boolean descending) {
    String header = "";
    String desc = descending ? "descending" : "ascending";
    switch (sortBy) {
      case NAME:
        header = "Sorting by Name";
        sortName(descending);
        break;
      case BALANCE:
        header = "Sorting by Balance";
        sortBalance(descending);
        break;
      case ID:
        header = "Sorting by Id";
      default:
        sortId(descending);
        break;
    }
    System.out.printf("### %s %s ###\n", header, desc);
    for (Customer c : customers)
      System.out.println(c);
    System.out.println();
  }

  public static void main(String[] args) {
    new Bank();
  }
}