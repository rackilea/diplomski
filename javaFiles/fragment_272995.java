public class CustomerIdHelper {
    public static String getID(Invoice invoice) {
        if (invoice instanceof InsuranceInvoices) {
            return ((InsuranceInvoices) invoices).getCustomerID();
        } else if ...
    }
}