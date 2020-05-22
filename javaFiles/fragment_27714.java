try (PdfDocument readDoc = new PdfDocument(new PdfReader(SRC))) {
  PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(readDoc, false);
  PdfFormField field = pdfAcroForm.getField(FIELDNAME);
  PdfString defaultAppearance = field.getDefaultAppearance(); // like "/MSGothic 9 Tf 0 g" 
  float fontSize;
  if (defaultAppearance != null) {
    String[] array = defaultAppearance.toString().split(" ");
    if (array.length > 2) {
      fontSize = Float.parseFloat(array[1]);
    }
  }
}