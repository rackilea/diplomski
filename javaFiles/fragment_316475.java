JLabel yourJLabelHere = null;
int moveToTheRight = 100;
int moveToTheBottom = 50;
PrinterJob printJob = PrinterJob.getPrinterJob();
printJob.setPrintable(new ComponentPrinter(yourJLabelHere, moveToTheRight, moveToTheBottom));
if (printJob.printDialog()) {
    try { 
        printJob.print();
    } catch(PrinterException pe) {
        System.out.println("Error printing: " + pe);
    }
}