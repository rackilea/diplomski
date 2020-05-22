public static void printReport(ArrayList<MyPane> nodeList) {
    System.out.println("Creating a printer job...");

    String printerName = CachedComponents.getPrinterName();

    Printer printer = null;
    for (Printer p : Printer.getAllPrinters()) {
        if (p.getName().equals(printerName)) {
            printer = p;
            break;
        }
    }

    PrinterJob job = PrinterJob.createPrinterJob(printer);
    if (job != null) {
        job.getJobSettings().setPrintQuality(PrintQuality.HIGH);

        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT,
                Printer.MarginType.HARDWARE_MINIMUM);

        boolean fail = false;
        for (int i=0; i<nodeList.size(); i++) {
            MyPane node = nodeList.get(i);

            double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
            node.getTransforms().add(new Scale(scaleX, scaleX));

            boolean printed = job.printPage(pageLayout, node);

            if (printed) {
                System.out.println("Printed.");
            } else {
                System.out.println("Printing failed.");
                fail = true;
            }
        }
        if (!fail) {
            job.endJob();
        }
    } else {
        System.out.println("Could not create a printer job.");
    }
}