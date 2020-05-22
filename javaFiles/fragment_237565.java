public void execute() {
    File inputFile = new File(path/to/the/file.pdf);
    PDDocument document = null;
    try {
        document = PDDocument.load(inputFile);

        int start = 1;
        int end = 1;
        int batchSize = 50;
        int finalBatchSize = document.getNumberOfPages() % batchSize;
        int noOfBatches = document.getNumberOfPages() / batchSize;
        for (int i = 1; i <= noOfBatches; i++) {
            start = end;
            end = start + batchSize;
            System.out.println("Batch: " + i + " start: " + start + " end: " + end);
            split(document, start, end);
        }
        // handling the remaining
        start = end;
        end += finalBatchSize;
        System.out.println("Final Batch  start: " + start + " end: " + end);
        split(document, start, end);

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        //close the document
    }
}

private void split(PDDocument document, int start, int end) throws IOException {
    List<File> fileList = new ArrayList<File>();
    Splitter splitter = new Splitter();
    splitter.setStartPage(start);
    splitter.setEndPage(end);
    List<PDDocument> splittedDocuments = splitter.split(document);
    String outputPath = Config.INSTANCE.getProperty("outputPath");
    PDFTextStripper stripper = new PDFTextStripper();

    for (int index = 0; index < splittedDocuments.size(); index++) {
        String pdfFullPath = document.getDocumentInformation().getTitle() + index + start+ ".pdf";
        PDDocument splittedDocument = splittedDocuments.get(index);

        splittedDocument.save(pdfFullPath);
    }
}