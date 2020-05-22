import java.awt.HeadlessException;
    import java.util.Scanner;

    import javax.swing.JOptionPane;

    public class Tester {

        private static String name;

    private static double withdraw;

    private static int pin;

    public static void main(String args[]) {
        Scanner kbInLine = new Scanner(System.in);
        Scanner kbIn = new Scanner(System.in);

        name = JOptionPane.showInputDialog(null, "Enter your name: ");

        String num = JOptionPane.showInputDialog("Enter your pin number: ");
        pin = Integer.parseInt(num);

        JOptionPane.showMessageDialog(null, "Login Success\n" + "Name : " + name + "\n" + "Pin Number : " + pin);

        BankAccount myAccount = new BankAccount(withdraw, name);

        int rc = getRC();
        processor(myAccount, rc);
    }

    private static int getRC() throws HeadlessException {
        String[] buttons = { "Deposit", "Withdraw", "Print Balance", "Exit" };
        int rc = JOptionPane.showOptionDialog(
            null,
            "What would you like to do?",
            "Confirmation",
            JOptionPane.INFORMATION_MESSAGE,
            0,
            null,
            buttons,
            buttons[2]);
        return rc;
    }

    private static void processor(BankAccount myAccount, int rc) throws HeadlessException, NumberFormatException {
        switch(rc) {
            case 0:
                processDeposit(myAccount, rc);
                break;
            case 1:
                processWithdraw(myAccount, rc);
                break;
            case 2:
                processBalance(myAccount, rc);
            default:
                processExit(rc);
                break;
        }
    }

    private static void processExit(int rc) throws HeadlessException {
        if(rc == -1) {
            JOptionPane.showMessageDialog(null, "\nThank you. Have a good day!");
            System.exit(0);
        }
    }

    private static void processDeposit(BankAccount myAccount, int rc) throws HeadlessException, NumberFormatException {
        double deposit;
        String dep = JOptionPane.showInputDialog("How much would you like to deposit?\n\t$ ");
        deposit = Double.parseDouble(dep);
        myAccount.deposit(deposit);

        JOptionPane.showMessageDialog(null, "You have deposited $" + dep + " into the account of " + name);
        processManager(myAccount);
    }

    private static void processWithdraw(BankAccount myAccount, int rc) throws HeadlessException, NumberFormatException {
        double withdraw;
        String with = JOptionPane.showInputDialog("How much would you like to withdraw?\n\t$");
        withdraw = Double.parseDouble(with);
        if(myAccount.getBalance() - withdraw >= 0) {
            myAccount.withdraw(withdraw);
            JOptionPane.showMessageDialog(null, "You have withdrawn $" + withdraw + " from the account of " + name
                    + ". The new balance is: " + myAccount.getBalance());
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Sorry, you have insufficient funds for this operation. Your existing balance is $"
                        + myAccount.getBalance());
        }
        processManager(myAccount);
    }

    private static void processBalance(BankAccount myAccount, int rc) throws HeadlessException {
        JOptionPane.showMessageDialog(null, "The balance in the account of " + name + " with the pin number " + pin
                + " is $" + myAccount.getBalance());
        processManager(myAccount);
    }

    private static void processManager(BankAccount myAccount) throws HeadlessException, NumberFormatException {
        int rc;
        String proceeds = JOptionPane.showInputDialog(null, "\nWould you like to do another transaction? (Y/N)");
        if(proceeds.equalsIgnoreCase("y")) {
            rc = getRC();
            processor(myAccount, rc);
        } else {
            processExit(-1);
        }
    }
}