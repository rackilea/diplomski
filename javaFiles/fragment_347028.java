class InvoiceCollector {
   private final List<Invoice> invoices = new ArrayList<>();

   public void addNewInvoices() {
     ... reads data from file and adds new objects to invoices

   public List<Invoice> getCurrentInvoices() {
     return new ArrayList<>(invoices);