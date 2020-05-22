public class Test {
    public static void main(String[] args) {
        Banking[] uaccounts;
        uaccounts = new Banking[100]; // setting up array
        int arrcount = 0; // setting counter for array
        int menu = 1; // Creating a variable to loop menu
        while (menu == 1) { // Creating the loop for the menu
            System.out.println("|=================================================|"); 
            System.out.println("|                                                 |");
            System.out.println("|                     MAIN MENU                   |");
            System.out.println("|  1. Create Account (BANK MANAGER RESTRICTED)    |");
            System.out.println("|  2. Check Account Balance                       |");
            System.out.println("|  3. Deposit Into Account                        |");
            System.out.println("|  4. Withdraw From Account                       |");
            System.out.println("|  5. Quit                                        |");
            System.out.println("|                                                 |");
            System.out.println("|=================================================|");

            int uinput = Integer.parseInt(JOptionPane.showInputDialog("Please select an option from above(1 - 4):"));
            if (uinput == 1) { // initiating menu option 1
                String full_name = JOptionPane.showInputDialog("Please enter clients full name:"); // creating some
                                                                                                    // variables
                String address = JOptionPane.showInputDialog("Please enter the clients address:");
                String password = JOptionPane.showInputDialog("Please enter the clients password:");
                int accid = (int) Math.random();// t(100000, 999999);
                System.out.println("Customers Account ID:" + accid);
                double balance = Double
                        .parseDouble(JOptionPane.showInputDialog("Please enter the client's starting balance:"));
                uaccounts[arrcount] = new Banking(full_name, address, accid, balance, password); // creating objectg in
                                                                                                    // array
                arrcount = arrcount + 1; // adding to counter for next time

            }
            if (uinput == 2) { // initiating menu option 2
                int acc_id_input = Integer.parseInt(JOptionPane.showInputDialog("Please enter your account ID:"));
                String password_input = JOptionPane.showInputDialog("Please enter your password:");
                int arrcount2 = arrcount - 1;
                System.out.println("found" + LoginUser(acc_id_input, password_input, uaccounts, arrcount2));
            }

        }
    }

    public static boolean LoginUser(int account_id, String password, Banking[] uaccounts, int arrcount) {
        boolean found = false;
        int accIndex = 0;
        for (int i = 0; i < uaccounts.length; i++) {
            if ((uaccounts[i].accid == account_id) && (uaccounts[i].pass.equals(password))) {
                found = true;
                accIndex = i;
                break;
            } else {
                found = false;
            }
        }
        return found;
    }
}