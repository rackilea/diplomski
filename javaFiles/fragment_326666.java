public class SomeQuartzJob implements Job {

     public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
          InvoiceDAO invoiceDAO = (InvoiceDAO) new InitialContext().lookup("java:global/myApp/myEJB/InvoiceDAO");
          List<Invoice> openInvoices = invoiceDAO.getAllByOpenStatus();
          // verbose exception handling and closing JNDI context omitted for brevity
     }
  }