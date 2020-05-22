PrinterJob job = PrinterJob.createPrinterJob();

if(job != null && job.showPrintDialog(root.getScene().getWindow())){
    Printer printer = job.getPrinter();
    PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);

    root.getTop().setVisible(false);
    root.getTop().setManaged(false);

    double width = root.getWidth();
    double height = root.getHeight();

    PrintResolution resolution = job.getJobSettings().getPrintResolution();

    width /= resolution.getFeedResolution();

    height /= resolution.getCrossFeedResolution();

    double scaleX = pageLayout.getPrintableWidth()/width/600;
    double scaleY = pageLayout.getPrintableHeight()/height/600;

    Scale scale = new Scale(scaleX, scaleY);

    root.getTransforms().add(scale);

    boolean success = job.printPage(pageLayout, root);
    if(success){
        job.endJob();
    }
    root.getTransforms().remove(scale);
}
root.getTop().setManaged(true);
root.getTop().setVisible(true);