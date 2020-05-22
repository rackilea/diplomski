protected void doPrint() {
PrinterJob job = PrinterJob.getPrinterJob();
Book book = new Book();
book.append(this, job.defaultPage());
printJob.setPageable(book);

boolean ok = job.printDialog();
if (ok) {
    try {
        job.print();
    } 
    catch (PrinterException ex) {
        ex.printStackTrace();
    } 
    finally {

    }
}
}