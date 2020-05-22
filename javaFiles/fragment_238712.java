PDDocument doc = new PDDocument();
PDPage page = new PDPage();
doc.addPage(page);

COSDictionary acroFormDict = new COSDictionary();
PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
doc.getDocumentCatalog().setAcroForm(acroForm);
acroForm.setFields(new ArrayList<>());

PDPushButton button = new PDPushButton(acroForm);
button.setPartialName("Btn1");

PDActionJavaScript actionJavaScript = new PDActionJavaScript("this.closeDoc();");
PDAnnotationAdditionalActions additionalActions = new PDAnnotationAdditionalActions();
additionalActions.setU(actionJavaScript);

// widget
PDAnnotationWidget widget = button.getWidgets().get(0);
widget.setActions(additionalActions);
widget.setRectangle(new PDRectangle(100, 700, 100, 50));

PDColor colourBlack = new PDColor(new float[] { 0, 0, 0 }, PDDeviceRGB.INSTANCE);
PDAppearanceCharacteristicsDictionary fieldAppearance
        = new PDAppearanceCharacteristicsDictionary(new COSDictionary());
fieldAppearance.setBorderColour(colourBlack);
widget.setAppearanceCharacteristics(fieldAppearance);

// Create appearance
PDAppearanceDictionary appearanceDictionary = new PDAppearanceDictionary();
PDAppearanceStream appearanceStream = new PDAppearanceStream(doc);
appearanceStream.setResources(new PDResources());
try (PDPageContentStream cs = new PDPageContentStream(doc, appearanceStream))
{
    PDRectangle bbox = new PDRectangle(widget.getRectangle().getWidth(), widget.getRectangle().getHeight());
    appearanceStream.setBBox(bbox);
    cs.setNonStrokingColor(0, 0, 0); // black
    cs.addRect(bbox.getLowerLeftX() + 0.5f, bbox.getLowerLeftY() + 0.5f, bbox.getWidth() - 1, bbox.getHeight() - 1);
    cs.stroke();

    // put some useful text
    cs.setFont(PDType1Font.HELVETICA, 20);
    cs.beginText();
    cs.newLineAtOffset(20, 20);
    cs.showText("Close");
    cs.endText();
}
appearanceDictionary.setNormalAppearance(appearanceStream);
widget.setAppearance(appearanceDictionary);

page.getAnnotations().add(widget);

acroForm.getFields().add(button);

doc.save("..../Button.pdf");
doc.close();