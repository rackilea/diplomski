public static PrintService setPrintService(String argPrintServiceName) throws PrinterException {
        PrintService psr = null;
    PrintService[] printServices = PrinterJob.lookupPrintServices();
    int i;
    for (i = 0; i < printServices.length; i++) {
    if (printServices[i].getName().equalsIgnoreCase(argPrintServiceName)) {
        psr = printServices[i];          
    break;
    }
    }
    if (i == printServices.length) {
    throw new PrinterException("Invalid print service name: " + argPrintServiceName);
    }
    return psr;
    }