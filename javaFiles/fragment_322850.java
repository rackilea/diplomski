public class ConcreteAccount extends Account{
    public ConcreteAccount (int accountId, int customerId, double balance) {
        super(accountId, customerId, balance);
    }

    public abstract double deposit(double sum) {
       //implementation here
    }
    public abstract double withdraw(double sum) {
       //implementation here
    }
}