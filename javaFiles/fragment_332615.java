public class BillingServrice {

  private static BillingServrice billingServrice;

  public static BillingServrice getInstance() {

    if(billingServrice == null) billingServrice = new BillingServrice();
    return billingServrice;

  }

  private Stage mainStage;
  private StackPane mainStackPane;
  private User user;
  private HibernateSession hibernateSession;

  private BillingServrice() {
    // You need to define the constuctor
  }


  // ... all the getters and setters


}