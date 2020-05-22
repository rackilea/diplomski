PdfReader reader = new PdfReader(src);
PdfDictionary page = reader.getPageN(11);
PdfArray annots = page.getAsArray(PdfName.ANNOTS); 
for (int i = 0; i < annots.size(); i++) {
    PdfDictionary annotation = annots.getAsDict(i);
    if (PdfName.LINK.equals(annotation.getAsName(PdfName.SUBTYPE))) {
        PdfArray d = annotation.getAsArray(PdfName.DEST);
        if (d == null) {  // in case the link has not a Dest but instead a GoTo action
            PdfDictionary action = annotation.getAsDict(PdfName.A);
            if (action != null)
                d = action.getAsArray(PdfName.D);
        }

        if (d != null && d.size() > 0) {
            System.out.println("Next destination -");
            PdfIndirectReference pageReference = d.getAsIndirectObject(0);

            // Work with target dictionary directly
            PdfDictionary pageDict = d.getAsDict(0);
            PdfArray boxArray = pageDict.getAsArray(PdfName.CROPBOX);
            if (boxArray == null) {
                boxArray = pageDict.getAsArray(PdfName.MEDIABOX);
            }
            Rectangle box = PdfReader.getNormalizedRectangle(boxArray);
            System.out.printf("* Target page object %s has cropbox %s\n", pageReference, box);

            // Work via page number
            for (int pageNr = 1; pageNr <= reader.getNumberOfPages(); pageNr++) {
                PRIndirectReference pp = reader.getPageOrigRef(pageNr);
                if (pp.getGeneration() == pageReference.getGeneration() && pp.getNumber() == pageReference.getNumber()) {
                    System.out.printf("* Target page %s has cropbox %s\n", pageNr, reader.getCropBox(pageNr));
                    break;
                }
            }
        }
    }
}