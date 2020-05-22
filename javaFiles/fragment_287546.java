JasperPrint jp = the_jasper_print_to_be_printed; // 
int i = 1; // Page Number to print
float zoom = 1f;

BufferedImage image = (BufferedImage) JasperPrintManager.printPageToImage(jp, i, zoom);
PrinterJob printJob = PrinterJob.getPrinterJob();
PageFormat pf = printJob.getPageFormat(null);
int paperWidth = Functions.StringToInt(pf.getImageableWidth());
int paperHeight = Functions.StringToInt(pf.getImageableHeight());
int x = 0, y = 0;
while (y < image.getHeight()) {
    x = 0;
    while (x < image.getWidth()) {
        Rectangle rect = new Rectangle(x, y, paperWidth, paperHeight);
        printImage(Functions.cropImage(image, rect), printJob);
        x += paperWidth;
    }
    y += paperHeight;
}