public class BankAccount { 
    double balance;

    BankAccount(double openingBalance){
        balance=openingBalance;
    }

    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public double withdraw (double amount){
        if (balance > amount){
            balance -= amount;
        }else if (amount > balance){
            System.out.print("Error");
        }else if (amount == balance){
            balance = 0;
        }
        // you can return the amount, or the balance, or whatever you want here...
        return amount;
    }
}