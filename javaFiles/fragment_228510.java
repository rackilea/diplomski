public static PdfAcroForm addAcroForm(PdfDocument pdf, Document doc) throws IOException {
    PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
    PdfTextFormField nameField = PdfFormField.createText(pdf);
    nameField.setFieldName("name");
    PdfWidgetAnnotation widget1 = new PdfWidgetAnnotation(new Rectangle(99, 525, 425, 15));
    pdf.getPage(1).addAnnotation(widget1);
    PdfWidgetAnnotation widget2 = new PdfWidgetAnnotation(new Rectangle(99, 425, 425, 15));
    pdf.getPage(1).addAnnotation(widget2);
    form.addField(nameField, pdf.getPage(1));
    nameField.addKid(widget1);
    nameField.addKid(widget2);
    return form;
}