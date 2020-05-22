public class Order {
   private int orderValue;
   //getters and setters, make protected
   public Order(int orderValue) {
      this.orderValue = orderValue;
   }
   protected int calculateOrderValue() {
      return this.orderValue;
   }
}
public class CreditOrder extends Order {
   private int orderValue;
   private float interestRate;
   //getters and setters for interestRate
   public CreditOrder(int orderValue, float interestRate) {
     super(orderValue);
     this.orderValue = orderValue;
     this.interestRate = interestRate;
   }
   public int calculateOrderValue() {
      return getOrderValue() * getInterestRate();
   }
}