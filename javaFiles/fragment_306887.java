try (   InputStream resource = SOURCE_STREAM;
        OutputStream os = INTERMEDIATE_OUTPUT_STREAM) {
    PdfReader reader = new PdfReader(resource);
    PdfStamper stamper = new PdfStamper(reader, os);
    PdfFormField field = PdfFormField.createSignature(stamper.getWriter());
    field.setFieldName("Signature");
    field.setWidget(new Rectangle(30, 830, 170, 770), PdfAnnotation.HIGHLIGHT_NONE);
    stamper.addAnnotation(field, 1);
    stamper.close();
}