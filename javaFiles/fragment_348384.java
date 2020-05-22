PrinterJob job = PrinterJob.createPrinterJob();
if (job != null && job.showPrintDialog(stage)){
    boolean success = job.printPage(stage.getScene().getRoot());
    if (success) {
        job.endJob();
    }
}