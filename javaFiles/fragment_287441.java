PrinterJob job = PrinterJob.getPrinterJob();
job.setPrintable(new HelloWorldPrinter());
HashPrintRequestAttributeSet printParams = new HashPrintRequestAttributeSet();
boolean ok = job.printDialog(printParams);
if (ok) {
    PageRanges pageRanges = (PageRanges) printParams.get(PageRanges.class);
    int pagesToBePrinted = getNumberOfPages(pageRanges);
    try {
        job.print(printParams);
    } catch (PrinterException e) {
        /* The job did not successfully complete */
    }
}