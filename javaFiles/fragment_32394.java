public class PaymentProcessor_$$Proxy extends PaymentProcessor  
{  
  public void processPayment(int amount)  
  {  
    PaymentProcessor instance = lookupBean();  
    instance.processPayment(amount);  
  }  

  private PaymentProcessor lookupBean()  
  {  
    //get the correct instance from the BeanManager and return it  
  }  
}