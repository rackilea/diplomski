public class CustomerLab {
  private static CustomerLab mCustLab;
  public List<Customer> mCustomers = new ArrayList<Customer>();

  /**
   * The private constructor for the Customer List Singleton class
   */
  private CustomerLab() {}

  public static CustomerLab getCustLab() {
    //instantiate a new CustomerLab if we didn't instantiate one yet
    if (mCustLab == null) {
        mCustLab = new CustomerLab();
    }
    return mCustLab;
  }
  //add methods here for insert, delete, search etc......
}