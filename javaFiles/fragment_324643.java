PdfDictionary pageDict = myReader.getPageN(1);
PdfArray annots = pageDict.getAsArray(PdfName.ANNOTS);
ArrayList<String> dests = new ArrayList<String>();
if (annots != null) {
  for (int i = 0; i < annots.size(); ++i) {
    PdfDictionary annotDict = annots.getAsDict(i);
    PdfName subType = annotDict.getAsName(PdfName.SUBTYPE);
    if (subType != null && PdfName.LINK.equals(subType)) {
      PdfDictionary action = annotDict.getAsDict(PdfName.A);
      if (action != null && PdfName.URI.equals(action.getAsName(PdfName.S)) {
        dests.add(action.getAsString(PdfName.URI).toString());
      } // else { its an internal link, meh }
    }
  }
}