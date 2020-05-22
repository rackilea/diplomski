public void printJavaComponent() {
PrinterJob job = PrinterJob.getPrinterJob();
job.setJobName("Print Java Component");

job.setPrintable (new Printable() {    
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return(NO_SUCH_PAGE);
        } else {
            Graphics2D g2d = (Graphics2D)g;
            g2d.translate(pageFormat.getImageableX(), 
            pageFormat.getImageableY());

            component_name_to_be_printed.paint(g2d);

            return(PAGE_EXISTS); 
        }
    }
});

if (job.printDialog()) {
    try {
        job.print();
    } catch (PrinterException e) {
        System.err.println(e.getMessage()); 
    }
}