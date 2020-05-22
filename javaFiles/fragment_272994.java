public class InvoiceWrapper {
    private String customerID;
    public String getCustomerID() {
        return customerID;
    }
    public InvoiceWrapper(BankInvoices invoice) {
       this.customerID = invoice.getCustomerID();
    }
    public InvoiceWrapper(InsuranceInvoices invoice) {
       this.customerID = invoice.getCustomerID();
    }
    // other constructors
}