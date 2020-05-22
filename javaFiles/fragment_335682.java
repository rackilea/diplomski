PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
aset.add(MediaSizeName.ISO_A4);
aset.add(new PrinterResolution(300, 300, PrinterResolution.DPI));
aset.add(new MediaPrintableArea(2, 2, 210 - 4, 297 - 4, MediaPrintableArea.MM));

PrinterJob pj = PrinterJob.getPrinterJob();
pj.setPrintable(new PrintTask());

if (pj.printDialog(aset)) {
    try {
        pj.print(aset);
    } catch (PrinterException ex) {
        ex.printStackTrace();
    }
}