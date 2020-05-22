public class Stage {

  private BillingServrice billingServrice;

  public Stage (BillingServrice billingServrice) {
    this.billingServrice = billingServrice;

  }

  void doSomething() {
     System.out.println( billingServrice.getUser() );
  }

}