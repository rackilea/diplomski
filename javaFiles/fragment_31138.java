private byte[] copyFormElements(byte[] sourceTemplate) throws IOException {
    PdfReader completeReader = new PdfReader(new ByteArrayInputStream(sourceTemplate));
    PdfDocument completeDoc = new PdfDocument(completeReader);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PdfWriter offsetWriter = new PdfWriter(out);
    PdfDocument offsetDoc = new PdfDocument(offsetWriter);
    offsetDoc.initializeOutlines();
    PdfPage blank = offsetDoc.addNewPage();
    PdfAcroForm originalForm = PdfAcroForm.getAcroForm(completeDoc, false);
    //      originalForm.getPdfObject().copyTo(offsetDoc,false);
    PdfAcroForm offsetForm = PdfAcroForm.getAcroForm(offsetDoc, true);

    for (String name : originalForm.getFormFields().keySet()) {
        PdfFormField field = originalForm.getField(name);
        PdfDictionary copied = field.getPdfObject().copyTo(offsetDoc, false);
        PdfFormField copiedField = PdfFormField.makeFormField(copied, offsetDoc);
        offsetForm.addField(copiedField, blank);
    }

    offsetDoc.close();
    completeDoc.close();
    return out.toByteArray();
}