PrinterJob job = PrinterJob.getPrinterJob();

try {
    job.setPrintService(myPrinter);
    job.setPageable(new PDFPageable(myDoc));
    job.print();
} catch (PrinterException e) {
    // Handle the exception.
}