HTMLPrinter target = new HTMLPrinter(editorPane);
PrinterJob printJob = PrinterJob.getPrinterJob();
printJob.setPrintable(target);
try{
    printJob.printDialog();
    printJob.print();
}catch(Exception e){
    e.printStackTrace();
}