public class Assignment4Test {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        final int Username = 3387;
        final int Password = 5183;
        final int AccountNumber = 22334455;

        int EnteredUsername;
        int EnteredPassword;
        int EnteredAccountNumber;
        for (int s = 0; s <= 3; s++) {
            if (s < 3) {
                System.out.println("Enter Username");
                EnteredUsername = console.nextInt();
                System.out.println("Username Entered is " + EnteredUsername);
                System.out.println("Enter Password");
                EnteredPassword = console.nextInt();
                System.out.println("Password Entered is " + EnteredPassword);
                System.out.println("Enter Account Number");
                EnteredAccountNumber = console.nextInt();
                System.out.println("Account Number Entered is " + EnteredAccountNumber);
                if (Username == EnteredUsername && (Password == EnteredPassword)
                        && (AccountNumber == EnteredAccountNumber)) {
                    System.out.println("Welcome");
                    new MyFrame().displayGui();
                    break;
                } else {
                    System.out.println("Wrong Username, Password or Account Number. Please try again.");
                }
            } else {
                System.out.println("3 incorrect enteries detected. Program is terminating, goodbye!");
            }
        }
    }

    static class MyFrame extends JFrame {

        JMenuBar menubar;

        JMenu TransferAnAmount;
        JMenuItem TransferAnAmountToAnotherAccount;

        JMenu ListRecentTransactions;
        JMenuItem ShowList;

        JMenu DisplayCurrentBalance;
        JMenuItem ShowBalance;

        JMenu ExitProgram;
        JMenuItem Exit;

        public MyFrame() {

            setLayout(new FlowLayout());

            menubar = new JMenuBar();
            setJMenuBar(menubar);

            TransferAnAmount = new JMenu("Transfer An Amount");
            menubar.add(TransferAnAmount);

            ListRecentTransactions = new JMenu("List Recent Transactions");
            menubar.add(ListRecentTransactions);

            DisplayCurrentBalance = new JMenu("Display Current Balance");
            menubar.add(DisplayCurrentBalance);

            ExitProgram = new JMenu("Exit Program");
            menubar.add(ExitProgram);

            TransferAnAmountToAnotherAccount = new JMenuItem("Transer an amount to another account");
            TransferAnAmount.add(TransferAnAmountToAnotherAccount);

            ShowList = new JMenuItem("Show List");
            ListRecentTransactions.add(ShowList);

            ShowBalance = new JMenuItem("Show Balance");
            DisplayCurrentBalance.add(ShowBalance);

            Exit = new JMenuItem("Exit Program");
            ExitProgram.add(Exit);

            event e = new event();
            Exit.addActionListener(e);

        }

        class event implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }

        }

        public void displayGui() {
            MyFrame gui = new MyFrame();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(600, 300);
            gui.setVisible(true);

        }

    }
}