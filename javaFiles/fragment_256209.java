public void showNormalFieldAppearanceTexts(PDDocument document) throws IOException {
    PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

    if (acroForm != null) {
        SimpleXObjectTextStripper stripper = new SimpleXObjectTextStripper();

        for (PDField field : acroForm.getFieldTree()) {
            if (field instanceof PDTerminalField) {
                PDTerminalField terminalField = (PDTerminalField) field;
                System.out.println();
                System.out.println("* " + terminalField.getFullyQualifiedName());
                for (PDAnnotationWidget widget : terminalField.getWidgets()) {
                    PDAppearanceDictionary appearance = widget.getAppearance();
                    if (appearance != null) {
                        PDAppearanceEntry normal = appearance.getNormalAppearance();
                        if (normal != null) {
                            Map<COSName, PDAppearanceStream> streams = normal.isSubDictionary() ? normal.getSubDictionary() :
                                Collections.singletonMap(COSName.DEFAULT, normal.getAppearanceStream());
                            for (Map.Entry<COSName, PDAppearanceStream> entry : streams.entrySet()) {
                                String text = stripper.getText(entry.getValue());
                                System.out.printf("  * %s: %s\n", entry.getKey().getName(), text);
                            }
                        }
                    }
                }
            }
        }
    }
}