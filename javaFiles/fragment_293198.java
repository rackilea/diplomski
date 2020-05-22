List<PDDocument> docs = new ArrayList<PDDocument>();
try {
    docs.add(PDDocument.load("c://test/test.pdf"));
    docs.add(PDDocument.load("c://test/test2.pdf"));
} catch (IOException e) {
    e.printStackTrace();
}

try {
    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    aset.add(MediaSizeName.ISO_A4);
    aset.add(new Copies(1));
    aset.add(Sides.ONE_SIDED);
    aset.add(Finishings.STAPLE);

    PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
    PrintService service = ServiceUI.printDialog(null, 200, 200,
            printService, defaultService, flavor, pras);

    if (service != null && !docs.isEmpty()) {
        for (PDDocument doc : docs) {
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setPrintService(service);
            doc.silentPrint(printJob);
        }
    }
} catch (PrinterException e) {
    e.printStackTrace();
} finally {
    for (PDDocument doc : docs) {
        if (doc != null) {
            try {
                doc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}