private static void printImage(BufferedImage image, PrinterJob printJob) {
    printJob.setPrintable(new Printable() {
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex != 0) {
                return NO_SUCH_PAGE;
            }
            graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            return PAGE_EXISTS;
        }
    });
    try {
        printJob.print();
    } catch (PrinterException e1) {
        e1.printStackTrace();
    }
}