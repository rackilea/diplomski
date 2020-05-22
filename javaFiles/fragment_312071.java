public static void printPdf (String filePath, String jobName) throws IOException, PrinterException {

    FileInputStream fileInputStream = new FileInputStream(filePath);
    byte[] pdfContent = new byte[fileInputStream.available()];
    fileInputStream.read(pdfContent, 0, fileInputStream.available());
    ByteBuffer buffer = ByteBuffer.wrap(pdfContent);

    final PDFFile pdfFile1 = new PDFFile(buffer);
    pdf_print_engine pages1 = new pdf_print_engine(pdfFile1);
    PrinterJob pjob = PrinterJob.getPrinterJob();
    PageFormat pfDefault = PrinterJob.getPrinterJob().defaultPage();
    Paper defaultPaper = new Paper();
    defaultPaper.setImageableArea(0, 0, defaultPaper.getWidth(), defaultPaper.getHeight());
    pfDefault.setPaper(defaultPaper);
    pjob.setJobName("Test");
    if (pjob.printDialog()) {
        // validate the page against the chosen printer to correct
        // paper settings and margins
        pfDefault = pjob.validatePage(pfDefault);
        Book book = new Book();

        book.append(pages1, pfDefault, pdfFile1.getNumPages());
        pjob.setPageable(book);

        try {
            pjob.print();
        } catch (PrinterException exc) {
            System.out.println(exc);
        }
    }