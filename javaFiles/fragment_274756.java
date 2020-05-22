PageFormat format = new PageFormat();
format.setOrientation(PageFormat.REVERSE_LANDSCAPE);

PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
aset.add(OrientationRequested.REVERSE_LANDSCAPE);
aset.add(MediaSizeName.JAPANESE_POSTCARD);

PrinterJob printerJob = PrinterJob.getPrinterJob();
printerJob.setPrintable(new ImagePrintable(sap.getGraphicImage()));
printerJob.defaultPage(format);
printerJob.print(aset);