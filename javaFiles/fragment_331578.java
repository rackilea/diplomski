import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TableInDialog {

  private List<Customer_Data> user;

  public TableInDialog() {
    // Sample data
    user = new ArrayList<>();
    user.add(new Customer_Data(15, "xyz", 44045, "login1", 80000, "Active", "Savings"));
    user.add(new Customer_Data(18, "abc", 43075, "login2", 80000, "Active", "Savings"));
  }

  public static void main(String[] args) {
    new TableInDialog().search();
  }

  public void search() {
    String s1 = "", s2 = "";
    s1 = JOptionPane.showInputDialog("Enter Account Number u want to find ", s2);

    String[] columns = new String[] {"Account Number", "Name", "Pincode",
        "User Login", "Balance", "Status", "Type"};
    Object[][] rows = new Object[1][columns.length];

    boolean found = false;
    for (int i = 0; i < user.size(); i++) {
      Customer_Data var = user.get(i);
      if (var.accountNum == Integer.parseInt(s1))
      {
        rows[0] = new Object[] {var.accountNum, var.name, var.pincode,
            var.login, var.startingBalance, var.status, var.type};
        found = true;
        break;
      }
    }

    if (found) {
      JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(rows, columns)),
          "sad", JOptionPane.PLAIN_MESSAGE);
    }
    else {
      JOptionPane.showMessageDialog(null, "Not Fount");
    }
  }
}

class Customer_Data {
  int accountNum;
  String name;
  int pincode;
  String login;
  int startingBalance;
  String status;
  String type;

  public Customer_Data(int accountNum, String name, int pincode, String login,
                       int startingBalance, String status, String type) {
    this.accountNum = accountNum;
    this.name = name;
    this.pincode = pincode;
    this.login = login;
    this.startingBalance = startingBalance;
    this.status = status;
    this.type = type;
  }
}