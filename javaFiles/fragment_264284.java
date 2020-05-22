import java.util.ArrayList;
import java.util.List;

public class Test{


    static class Account {

        private String AccountName;
        private int AccountNumber;
        private double AccountBalance;

        public Account(String accountName, int accountNumber, double accountBalance)
        {
            this.AccountName = accountName;
            this.AccountNumber = accountNumber;
            this.AccountBalance = accountBalance;
        }

        public Account()
        {
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String accountName) {
            AccountName = accountName;
        }

        public int getAccountNumber() {
            return AccountNumber;
        }

        public void setAccountNumber(int accountNumber) {
            AccountNumber = accountNumber;
        }

        public double getAccountBalance() {
            return AccountBalance;
        }

        public void setAccountBalance(double accountBalance) {
            AccountBalance = accountBalance;
        }       


    }

    static class Bank {
    private List<Account> accountList = new ArrayList<>();
    private String inputStr = "";
    private int inputInt = 0;

    public Bank() {
    }

    public Bank(String string, int i) {
        inputStr = string;
        inputInt = i;
    }

    public boolean addAccount(Account account) {
        if(!accountList.contains(account)) {
            accountList.add(account);
            return true;
        }
        return false;
    }

}

        public static void main(String[] args)
        {

            Bank bank = new Bank("qLOwyONvKsM58ZdV& &yo", 1);

            Account account = new Account("aucchQitgyzLV", 6329668, 479389.0);
            Account account5 = new Account("aucchQitgyzLV", 6329668, 479389.0);
            Account account2 = new Account();
            Account account3 = new Account();
            Account account4 = new Account("sgdgrt", 0, 0.1);
            Account account6 = new Account("sgdgrt", 0, 0.1);


            System.out.println( "account added: "+bank.addAccount(account));
            System.out.println("account5 added: "+bank.addAccount(account5));

            System.out.println( "account2 added: "+bank.addAccount(account2));
            System.out.println("account3 added: "+bank.addAccount(account3));

            System.out.println("account4 added: "+bank.addAccount(account4));
            System.out.println("account6 added: "+bank.addAccount(account6));

        }

}