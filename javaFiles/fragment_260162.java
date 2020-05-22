public static File embedFile(File inputPdf, File embeddedFile, String embeddedFileName, String embeddedFileMimeType)
        throws IOException {

    File outputPdf = new File("./test.pdf");

    PdfReader reader = new PdfReader(inputPdf.getAbsolutePath());
    PdfWriter writer = new PdfWriter(outputPdf.getAbsolutePath());
    PdfADocument pdfDoc = new PdfADocument(reader, writer);

    // Add attachment
    PdfDictionary parameters = new PdfDictionary();
    parameters.put(PdfName.ModDate, new PdfDate().getPdfObject());
    PdfFileSpec fileSpec = PdfFileSpec.createEmbeddedFileSpec(pdfDoc, embeddedFile.getAbsolutePath(), embeddedFileName,
            embeddedFileName, new PdfName(embeddedFileMimeType), parameters, PdfName.Data);
    fileSpec.put(new PdfName("AFRelationship"), new PdfName("Data"));
    pdfDoc.addFileAttachment(embeddedFileName, fileSpec);
    PdfArray array = new PdfArray();
    array.add(fileSpec.getPdfObject().getIndirectReference());
    pdfDoc.getCatalog().put(new PdfName("AF"), array);

    pdfDoc.close();
    reader.close();
    writer.close();

    return outputPdf;

}