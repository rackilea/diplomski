public static void insertElementsToTableCell(XWPFTableCell cell, List<IBodyElement> elements) {
  for (IBodyElement element :  elements) {
   if (element instanceof XWPFParagraph) {
    XWPFParagraph paragraph = (XWPFParagraph) element;
    cell.getCTTc().getPList().add(paragraph.getCTP());
    //System.out.println(cell.getCTTc());
    cell.addParagraph(paragraph);
   }
  }
 }