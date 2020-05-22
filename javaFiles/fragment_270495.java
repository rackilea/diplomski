File pdf = new File("Fonts.pdf");
final PDDocument document = PDDocument.load(pdf);

FileInputStream fontFile = new FileInputStream(new File("DroidSans.ttf"));
PDFont font = PDType0Font.load(document, fontFile, false);

//1. embedd and register the font (Catalog dict)
PDAcroForm pDAcroForm = document.getDocumentCatalog().getAcroForm();
//create a new font resource
PDResources res = pDAcroForm.getDefaultResources();
if (res == null) res = new PDResources();
COSName fontName = res.add(font);
pDAcroForm.setDefaultResources(res);

//2. Now change the font of form field to the newly added font
PDField field = pDAcroForm.getField("text");
//field.setValue("Same font in form text field (updated with PDFBox)");

COSDictionary dict = field.getCOSObject();
COSString defaultAppearance = (COSString) dict.getDictionaryObject(COSName.DA);

if (defaultAppearance != null){
    String currentValue = dict.getString(COSName.DA);
    //replace the font - this should be improved with a more general version
    dict.setString(COSName.DA,currentValue.replace("F2", fontName.getName()));

    //remove F2 completely
    COSDictionary resources = res.getCOSObject();
    for(Entry<COSName, COSBase> resource : resources.entrySet()) {
        if(resource.getKey().equals(COSName.FONT)) {
            COSObject fonts = (COSObject)resource.getValue();
            COSDictionary fontDict = (COSDictionary)fonts.getObject();

            COSName toBeRemoved=null;
            for(Entry<COSName, COSBase> item : fontDict.entrySet()) {
                if(item.getKey().getName().equals("F2")) {
                    toBeRemoved = item.getKey();
                }
            }
            if(toBeRemoved!=null) {
                fontDict.removeItem(toBeRemoved);
            }
        }
    }

if(pDAcroForm.getNeedAppearances()) {
    pDAcroForm.refreshAppearances();
    pDAcroForm.setNeedAppearances(false);
}

//Flatten the document
pDAcroForm.flatten();

//Save the document
document.save("Form-Test-Result.pdf");
document.close();