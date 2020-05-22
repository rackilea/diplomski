import java.util.concurrent.Semaphore;

public class Account {
  private Semaphore semaphore = new Semaphore(1);
  private double balance = 0;

  public void withdraw(double amount){
    deposit(amount * -1);
  }

  public void deposit(double amount){
    semaphore.acquireUninterruptibly();
    balance += amount;
    semaphore.release();
  }  
}