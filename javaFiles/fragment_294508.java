private void print() {
    TextFlow printArea = new TextFlow(new Text(textArea.getText()));

    PrinterJob printerJob = PrinterJob.createPrinterJob();

    if (printerJob != null && printerJob.showPrintDialog(textArea.getScene().getWindow())) {
        PageLayout pageLayout = printerJob.getJobSettings().getPageLayout();
        printArea.setMaxWidth(pageLayout.getPrintableWidth());

        if (printerJob.printPage(printArea)) {
            printerJob.endJob();
            // done printing
        } else {
            System.out.println("Failed to print");
        }
    } else {
        System.out.println("Canceled");
    }
}