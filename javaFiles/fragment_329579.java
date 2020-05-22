protected void doPrint(boolean useBook) {
    RectangleThingy rectangleThingy = new RectangleThingy();
    System.out.println("doPrint("+useBook+")");
    try
    {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        if (useBook)
        {
            Book book = new Book();
            book.append(rectangleThingy, getMinimumMarginPageFormat(printJob));
            printJob.setPageable(book);
        }
        else
        {
            printJob.setPrintable(rectangleThingy);        
        }
        if (printJob.printDialog())
            printJob.print();
    } 
    catch(PrinterException pe) {
        System.out.println("Error printing: " + pe);
    }
}