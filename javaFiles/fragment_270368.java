//Loading an existing PDF document
File file1 = new File("sample1.pdf");
PDDocument doc1 = null;
try {
    doc1 = PDDocument.load(file1);
} catch (IOException e1) {
    e1.printStackTrace();
}

File file2 = new File("sample2.pdf");
PDDocument doc2 = null;
try {
    doc2 = PDDocument.load(file2);
} catch (IOException e1) {
    e1.printStackTrace();
}

//Instantiating PDFMergerUtility class
PDFMergerUtility PDFmerger = new PDFMergerUtility();

//Setting the destination file
PDFmerger.setDestinationFileName("merged.pdf");

//adding the source files
PDFmerger.addSource(file1);
PDFmerger.addSource(file2);

//Merging the two documents
try {
    PDFmerger.mergeDocuments();
} catch (COSVisitorException | IOException e) {
    e.printStackTrace();
}

System.out.println("Documents merged");
//Closing the documents
try {
    doc1.close();
} catch (IOException e) {
    e.printStackTrace();
}
try {
    doc2.close();
} catch (IOException e) {
    e.printStackTrace();
}