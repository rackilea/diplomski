public void printThis(String localPath) {

    // note you can use overloaded forms of the Image constructor
    // if you want to scale, etc
    Image image = new Image(getClass().getResource(localPath).toExternalForm());
    new Thread(() -> printImage(image)).start();
}

public void printImage(Image image) {
    ImageView imageView = new ImageView(image);
    PrinterJob printJob = PrinterJob.createPrinterJob();
    if (printJob != null) {
        // scale image if necessary by using imageView.setPreserveRatio(true)
        // along with imageView.setFitWidth(...) and imageView.setFitHeight(...)
        boolean success = printJob.printPage(imageView);
        if (success) {
            printJob.endJob();
        }
    }
}