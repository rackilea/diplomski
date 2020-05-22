PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
aset.add(new PrinterResolution(300, 300, PrinterResolution.DPI));
aset.add(new MediaPrintableArea(0, 0, 150, 100, MediaPrintableArea.MM));

PrinterJob pj = PrinterJob.getPrinterJob();
pj.setPrintable(new PrintTask()); // You Printable here

if (pj.printDialog(aset)) {
    try {
        pj.print(aset);
    } catch (PrinterException ex) {
        ex.printStackTrace();
    }
}