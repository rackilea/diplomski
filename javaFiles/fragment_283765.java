PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
attributes.add(DialogTypeSelection.NATIVE);
PrinterJob printJob = PrinterJob.getPrinterJob();

if (printJob.printDialog(attributes)) 
{
    PrintService ps=printJob.getPrintService();                 
    printerName=ps.getName();
    PageFormat pFormat = printJob.getPageFormat(attributes);
    System.out.println(" orientation "+pFormat.getOrientation());
}