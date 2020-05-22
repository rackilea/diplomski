public class BankAccount {

    private double balance;

    private String name;

    public BankAccount(double b, String n) {
        this.balance = b;
        this.name = n;
    }

    public void deposit(double d) {
        balance += d;
    }

    public void withdraw(double w) {
        balance -= w;
    }

    public String nickname() {
        System.out.print("Enter a new name: ");
        Scanner kbIn = new Scanner(System.in);
        String n = kbIn.nextLine();
        return n;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}