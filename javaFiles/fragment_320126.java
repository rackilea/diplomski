/**
* Sets the printer service to be used for printing
*
* @param argPrintServiceName
* @throws PrinterException
*/
public void setPrintService(String argPrintServiceName) throws PrinterException {
PrintService[] printServices = PrinterJob.lookupPrintServices();
int i;
for (i = 0; i < printServices.length; i++) {
if (printServices[i].getName().equalsIgnoreCase(argPrintServiceName)) {
printerJob.setPrintService(printServices[i]);
break;
}
}
if (i == printServices.length) {
throw new PrinterException(“Invalid print service name: ” + argPrintServiceName);
}
}