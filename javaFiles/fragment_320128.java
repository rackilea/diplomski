public PrintPdf(byte[] content, String jobName, PrintService ps) throws  
        IOException, PrinterException 
        {
        initialize(content, jobName, ps);
    } 



 public PrintPdf(InputStream inputStream, String jobName, PrintService ps)
    {
     *
     *
     initialize(pdfContent, jobName, ps);
    }