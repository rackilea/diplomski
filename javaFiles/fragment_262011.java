public List<PdfFormField> getFields() {
    final List<PdfFormField> pdfFormFields = new ArrayList<>();
    final PdfDictionary acroFormDict = pdf.getCatalog().getPdfObject().getAsDictionary(PdfName.AcroForm);
    if (acroFormDict != null) {
        final PdfArray fields = acroFormDict.getAsArray(PdfName.Fields);
        if(fields != null) {
            fillPdfFormFields(fields, pdfFormFields);
        }
    }
    return pdfFormFields;
}
private List<PdfFormField> fillPdfFormFields(PdfArray array, List<PdfFormField> fields) {
    array.forEach(pdfObject -> {
        final PdfFormField field = PdfFormField.makeFormField(pdfObject, pdfFile);
        fields.add(field);
        final PdfArray fieldKids = field.getKids();
        if (fieldKids != null) {
            fillPdfFormFields(fieldKids, fields);
        }
    });
    return fields;
}