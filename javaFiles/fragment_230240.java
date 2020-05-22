final int FLAG_MULTILINE = 1 << 12;
final int FLAG_COMB = 1 << 24;

PDDocument doc = PDDocument.load(originalStream);
PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();

PDType0Font font = PDType0Font.load(doc, fontStream, false);
String font_name = acroForm.getDefaultResources().add(font).getName();

for (PDField field : acroForm.getFieldTree()) {
    if (field instanceof PDTextField) {
        PDTextField textField = (PDTextField) field;
        textField.getCOSObject().removeItem(COSName.MAX_LEN);
        textField.getCOSObject().setFlag(COSName.FF, FLAG_COMB | FLAG_MULTILINE, false);;
        textField.setDefaultAppearance(String.format("/%s 0 Tf 0 g", font_name));
        textField.getWidgets().forEach(w -> w.getAppearance().setNormalAppearance((PDAppearanceEntry)null));
        textField.setValue("Test");
    }
}