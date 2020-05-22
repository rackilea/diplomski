public class BankService {
  private CustomerService customerService;
  private BillPaymentService billPaymentService;
  @Required
  public void setCustomerService(CustomerService customerService) {
   this.customerService = customerService;
  }
  @Required
  public void setBillPaymentService(BillPaymentService billPaymentService) {
  this.billPaymentService = billPaymentService;
}
}