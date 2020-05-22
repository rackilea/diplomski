PDDocument document = new PDDocument();
PDPage page = new PDPage(PDRectangle.A4);

document.addPage(page);

PDAcroForm acroForm = new PDAcroForm(document);

// not needed, we have appearance streams
//acroForm.setNeedAppearances(true);

acroForm.setXFA(null);
document.getDocumentCatalog().setAcroForm(acroForm);

PDFont font = PDType1Font.HELVETICA;

PDResources res = new PDResources();
COSName fontName = res.add(font);
acroForm.setDefaultResources(res);
acroForm.setDefaultAppearance('/' + fontName.getName() + " 10 Tf 0 g");

PDPageContentStream contents = new PDPageContentStream(document, page);

List<String> options = Arrays.asList("a", "b", "c");
PDRadioButton radioButton = new PDRadioButton(acroForm);
radioButton.setPartialName("RadioButtonParent");
// removed per advice of Maruan Sahyoun, setValue didn't work anymore
//radioButton.setExportValues(options);
radioButton.getCOSObject().setName(COSName.DV, options.get(1));
radioButton.setFieldFlags(49152);
int on = 1;

List<PDAnnotationWidget> widgets = new ArrayList<>();
for (int i = 0; i < options.size(); i++)
{
    PDAppearanceCharacteristicsDictionary fieldAppearance = new PDAppearanceCharacteristicsDictionary(new COSDictionary());
    fieldAppearance.setBorderColour(new PDColor(new float[] { 0, 0, 0 }, PDDeviceRGB.INSTANCE));
    PDAnnotationWidget widget = new PDAnnotationWidget();
    widget.setRectangle(new PDRectangle(30, 811 - i * (21), 16, 16));
    widget.setAppearanceCharacteristics(fieldAppearance);
    widget.setAnnotationFlags(4);
    widget.setPage(page);
    widget.setParent(radioButton);

    String offNString = "0 G\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  7.5 0 m\n"
            + "  7.5 4.1423 4.1423 7.5 0 7.5 c\n"
            + "  -4.1423 7.5 -7.5 4.1423 -7.5 0 c\n"
            + "  -7.5 -4.1423 -4.1423 -7.5 0 -7.5 c\n"
            + "  4.1423 -7.5 7.5 -4.1423 7.5 0 c\n"
            + "  s\n"
            + "Q";
    String onNString = "0 G\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  7.5 0 m\n"
            + "  7.5 4.1423 4.1423 7.5 0 7.5 c\n"
            + "  -4.1423 7.5 -7.5 4.1423 -7.5 0 c\n"
            + "  -7.5 -4.1423 -4.1423 -7.5 0 -7.5 c\n"
            + "  4.1423 -7.5 7.5 -4.1423 7.5 0 c\n"
            + "  s\n"
            + "Q\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  3.5 0 m\n"
            + "  3.5 1.9331 1.9331 3.5 0 3.5 c\n"
            + "  -1.9331 3.5 -3.5 1.9331 -3.5 0 c\n"
            + "  -3.5 -1.9331 -1.9331 -3.5 0 -3.5 c\n"
            + "  1.9331 -3.5 3.5 -1.9331 3.5 0 c\n"
            + "  f\n"
            + "Q";
    String offDString = "0.749023 g\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  8 0 m\n"
            + "  8 4.4185 4.4185 8 0 8 c\n"
            + "  -4.4185 8 -8 4.4185 -8 0 c\n"
            + "  -8 -4.4185 -4.4185 -8 0 -8 c\n"
            + "  4.4185 -8 8 -4.4185 8 0 c\n"
            + "  f\n"
            + "Q\n"
            + "0 G\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  7.5 0 m\n"
            + "  7.5 4.1423 4.1423 7.5 0 7.5 c\n"
            + "  -4.1423 7.5 -7.5 4.1423 -7.5 0 c\n"
            + "  -7.5 -4.1423 -4.1423 -7.5 0 -7.5 c\n"
            + "  4.1423 -7.5 7.5 -4.1423 7.5 0 c\n"
            + "  s\n"
            + "Q";
    String onDString = "0.749023 g\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  8 0 m\n"
            + "  8 4.4185 4.4185 8 0 8 c\n"
            + "  -4.4185 8 -8 4.4185 -8 0 c\n"
            + "  -8 -4.4185 -4.4185 -8 0 -8 c\n"
            + "  4.4185 -8 8 -4.4185 8 0 c\n"
            + "  f\n"
            + "Q\n"
            + "0 G\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  7.5 0 m\n"
            + "  7.5 4.1423 4.1423 7.5 0 7.5 c\n"
            + "  -4.1423 7.5 -7.5 4.1423 -7.5 0 c\n"
            + "  -7.5 -4.1423 -4.1423 -7.5 0 -7.5 c\n"
            + "  4.1423 -7.5 7.5 -4.1423 7.5 0 c\n"
            + "  s\n"
            + "Q\n"
            + "0 g\n"
            + "q\n"
            + "  1 0 0 1 8 8 cm\n"
            + "  3.5 0 m\n"
            + "  3.5 1.9331 1.9331 3.5 0 3.5 c\n"
            + "  -1.9331 3.5 -3.5 1.9331 -3.5 0 c\n"
            + "  -3.5 -1.9331 -1.9331 -3.5 0 -3.5 c\n"
            + "  1.9331 -3.5 3.5 -1.9331 3.5 0 c\n"
            + "  f\n"
            + "Q";
    COSDictionary apNDict = new COSDictionary();
    COSStream offNStream = new COSStream();
    offNStream.setItem(COSName.BBOX, new PDRectangle(16, 16));
    offNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    offNStream.setItem(COSName.TYPE, COSName.XOBJECT);
    offNStream.setItem(COSName.SUBTYPE, COSName.FORM);
    OutputStream os = offNStream.createOutputStream(COSName.FLATE_DECODE);
    os.write(offNString.getBytes());
    os.close();
    apNDict.setItem(COSName.Off, offNStream);

    COSStream onNStream = new COSStream();
    onNStream.setItem(COSName.BBOX, new PDRectangle(16, 16));
    onNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    onNStream.setItem(COSName.TYPE, COSName.XOBJECT);
    onNStream.setItem(COSName.SUBTYPE, COSName.FORM);
    os = onNStream.createOutputStream(COSName.FLATE_DECODE);
    os.write(onNString.getBytes());
    os.close();
    apNDict.setItem(options.get(i), onNStream);

    COSDictionary apDDict = new COSDictionary();
    COSStream offDStream = new COSStream();
    offDStream.setItem(COSName.BBOX, new PDRectangle(16, 16));
    offDStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    offDStream.setItem(COSName.TYPE, COSName.XOBJECT);
    offDStream.setItem(COSName.SUBTYPE, COSName.FORM);
    os = offDStream.createOutputStream(COSName.FLATE_DECODE);
    os.write(offDString.getBytes());
    os.close();
    apDDict.setItem(COSName.Off, offDStream);

    COSStream onDStream = new COSStream();
    onDStream.setItem(COSName.BBOX, new PDRectangle(16, 16));
    onDStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    onDStream.setItem(COSName.TYPE, COSName.XOBJECT);
    onDStream.setItem(COSName.SUBTYPE, COSName.FORM);
    os = onDStream.createOutputStream(COSName.FLATE_DECODE);
    os.write(onDString.getBytes());
    os.close();
    apDDict.setItem(options.get(i), onDStream);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    PDAppearanceEntry appearanceNEntry = new PDAppearanceEntry(apNDict);
    appearance.setNormalAppearance(appearanceNEntry);
    PDAppearanceEntry appearanceDEntry = new PDAppearanceEntry(apDDict);
    appearance.setDownAppearance(appearanceDEntry);

    widget.setAppearance(appearance);

    widget.setAppearanceState(i == on ? options.get(i) : "Off");

    widgets.add(widget);
    page.getAnnotations().add(widget);

    contents.beginText();
    contents.setFont(font, 10);
    contents.newLineAtOffset(56, 811 - i * (21) + 4);
    contents.showText(options.get(i));
    contents.endText();
}
radioButton.setWidgets(widgets);
acroForm.getFields().add(radioButton);

contents.close();
try (FileOutputStream output = new FileOutputStream("test.pdf"))
{
    document.save(output);
}
document.close();