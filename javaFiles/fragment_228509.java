public static PdfAcroForm addAcroForm(PdfDocument pdf, Document doc) throws IOException {
    Paragraph title = new Paragraph("Test Form")
            .setTextAlignment(TextAlignment.CENTER)
            .setFontSize(16);
    doc.add(title);
    doc.add(new Paragraph("Full name:").setFontSize(12));

    PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
    PdfTextFormField nameField = PdfFormField.createText(pdf,
            new Rectangle(99, 525, 425, 15), "name", "");
    for (int i = 1; i < 8; i++) {
        form.addField(nameField, pdf.getPage(i));
    }
    return form;
}