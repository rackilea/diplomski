import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Account {
  private Semaphore semaphore = new Semaphore(1);
  private double balance = 0;

  public void withdraw(double amount){
    deposit(amount * -1);
  }

  public void deposit(double amount){
    try {
      semaphore.tryAcquire(1, TimeUnit.SECONDS);
      balance += amount;
      semaphore.release();
    } 
    catch (InterruptedException e) {

      //Probably want to throw a more specific exception type here...
      throw new RuntimeException("Timed out waiting for an account balance...");
    }
  }  
}