AttributeSet attributes = new HashPrintServiceAttributeSet(
    new PrinterName(printerName, Locale.getDefault()));
PrintService[] services = PrintServiceLookup.lookupPrintServices(
    DocFlavor.SERVICE_FORMATTED.PRINTABLE,
    attributes);
PrintService printService = services[0];
PrintServiceAttributeSet printServiceAttributes = printService.getAttributes();
PrinterState printerState = (PrinterState) printServiceAttributes.get(PrinterState.class);