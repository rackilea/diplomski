private void initialize(byte[] pdfContent, String jobName, PrintService ps) throws      
 IOException, PrinterException 
 {
  *
  *
        pjob = PrinterJob.getPrinterJob();
        pjob.setPrintService(ps);
  *
  *
  ...
 }