public class Stage {

  private BillingServrice billingServrice;

  public Stage () {
    this.billingServrice = BillingServrice.getInstance();

  }

  void doSomething() {
     System.out.println( billingServrice.getUser() );
  }

}