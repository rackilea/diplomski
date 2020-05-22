public void printimg() throws FileNotFoundException, PrintException, InterruptedException {
    String filename = ("item.text"); // THIS IS THE TEXT FILE TO PRINT
    try{
    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    DocFlavor flavor = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8; //  FILE IS .txt TYPE
    PrintService printService[] =
            PrintServiceLookup.lookupPrintServices(flavor, pras);
    PrintService defaultService =
            PrintServiceLookup.lookupDefaultPrintService();
    PrintService service = ServiceUI.printDialog(null, 200, 200,
            printService, defaultService, flavor, pras);
    if (service != null) {
        DocPrintJob job = service.createPrintJob();
        FileInputStream fis = new FileInputStream(filename);
        DocAttributeSet das = new HashDocAttributeSet();
        Doc doc = new SimpleDoc(fis, flavor, das);
        job.print(doc, pras);

    }
    }
    catch(Exception a){
        JOptionPane.showMessageDialog(null, "OPeration Failed");
    }
}