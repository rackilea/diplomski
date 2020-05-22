public class BillingServrice {

  private Stage mainStage;
  private StackPane mainStackPane;
  private User user;
  private HibernateSession hibernateSession;

  public BillingServrice() {
    // create all the other objects here
    // pass this as parameter
    mainStage = new Stage(this);
    mainStackPane= new StackPane (this);
  }

  // ... all the getters and setters
}