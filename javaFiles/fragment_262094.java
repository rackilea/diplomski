/**
 * adds a group (aka Layer) to PDF document that is only visible when printing
 * 
 * @param document
 * @throws IOException
 */
private static void addPrintOnlyLayer(PDDocument document) throws IOException {
    /* kinda constants */
    COSName printName = COSName.getPDFName("Print");
    COSArray printCategory = new COSArray();
    printCategory.add(printName);
    COSDictionary printState = new COSDictionary();
    printState.setItem("PrintState", COSName.ON);
    /* kinda constants */

    PDDocumentCatalog catalog = document.getDocumentCatalog();
    PDOptionalContentProperties ocProps = catalog.getOCProperties();
    if (ocProps == null) {
        ocProps = new PDOptionalContentProperties();
        ocProps.setBaseState(BaseState.OFF);
        catalog.setOCProperties(ocProps);
    }

    COSDictionary ocPropsDict = (COSDictionary) ocProps.getCOSObject();
    COSDictionary dDict = ocPropsDict.getCOSDictionary(COSName.D);
    dDict.setItem(COSName.AS, new COSArray());

    PDOptionalContentGroup printOnlyGroup = null;
    if (ocProps.hasGroup(PRINT_ONLY_GROUP_NAME)) {
        printOnlyGroup = ocProps.getGroup(PRINT_ONLY_GROUP_NAME);
    } else {
        printOnlyGroup = new PDOptionalContentGroup(PRINT_ONLY_GROUP_NAME);
        ocProps.addGroup(printOnlyGroup);
    }

    COSDictionary printOnlyGroupDict = printOnlyGroup.getCOSObject();
    COSArray ocgs = new COSArray();
    ocgs.add(printOnlyGroupDict);

    COSDictionary usageDict = new COSDictionary();
    usageDict.setItem("Print", printState);

    printOnlyGroupDict.setItem("Usage", usageDict);

    COSDictionary asPrint = new COSDictionary();
    asPrint.setItem("Event", printName);
    asPrint.setItem("Category", printCategory);
    asPrint.setItem(COSName.OCGS, ocgs);

    dDict.getCOSArray(COSName.AS).add(asPrint);
}

/*** somewhere else ***/
PDDocument pdDoc = new PDDocument();
pdDoc.setVersion(1.7f);
addPrintOnlyLayer(pdDoc);
PDPage page = new PDPage(new PDRectangle(1000,2000));
pdDoc.addPage(page);

PDPageContentStream content = new PDPageContentStream(pdDoc, page);

/* add content that will only visible on screen */
content.set...
content.add...

/* add white rectangle covering everything that we had so far */        
content.beginMarkedContent(COSName.OC, pdDoc.getDocumentCatalog().getOCProperties().getGroup(PRINT_ONLY_GROUP_NAME));
// TODO: maybe get rect size from page dimensions dynamically
content.setNonStrokingColor(Color.WHITE);
content.addRect(0,0,1000,2000);// here, I know the size of my page
content.fill();
/* here, we could add more content that is visible ONLY on printer but NOT on screen */
content.endMarkedContent();

/* stroke around the page, so printing on larger paper will have a border */
/* drop later */
content.addRect(0,0,1000,2000);
content.stroke();

/* now add content that will be visible on the print out AND screen */
content.set...;
content.add...;

/* close content of page */
content.close();