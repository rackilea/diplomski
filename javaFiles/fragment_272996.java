public class CustomerIdHelper {
    public static String getID(Invoice invoice) {
        Method method = invoice.getClass().getDeclaredMethod("getCustomerId");
        return (String) method.invoke(invoice);
    }
}