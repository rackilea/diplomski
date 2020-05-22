/**
 * Create a page stamp. New content and annotations, including new fields, are allowed.
 * The fields added cannot have parents in another pages. This method modifies the PdfReader instance.<p>
 * The general usage to stamp something in a page is:
 * <p>
 * <pre>
 * PdfImportedPage page = copy.getImportedPage(reader, 1);
 * PdfCopy.PageStamp ps = copy.createPageStamp(page);
 * ps.addAnnotation(PdfAnnotation.createText(copy, new Rectangle(50, 180, 70, 200), "Hello", "No Thanks", true, "Comment"));
 * PdfContentByte under = ps.getUnderContent();
 * under.addImage(img);
 * PdfContentByte over = ps.getOverContent();
 * over.beginText();
 * over.setFontAndSize(bf, 18);
 * over.setTextMatrix(30, 30);
 * over.showText("total page " + totalPage);
 * over.endText();
 * ps.alterContents();
 * copy.addPage(page);
 * </pre>
 * @param iPage an imported page
 * @return the <CODE>PageStamp</CODE>
 */
public PageStamp createPageStamp(PdfImportedPage iPage)