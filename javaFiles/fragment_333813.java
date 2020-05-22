PdfReader tocReader = new PdfReader("toc.pdf");
page = copy.getImportedPage(tocReader, 1);
stamp = copy.createPageStamp(page);
int tocPageCount = 1;
Paragraph paragraph;
PdfAction action;
PdfAnnotation link;
float y = 770;
ColumnText colTxt = new ColumnText(stamp.getOverContent());
colTxt.setSimpleColumn(36, 36, 559, y);
for (TocModel tocModel : toc) {
    paragraph = new Paragraph(tocModel.getTitle());
    paragraph.add(new Chunk(new DottedLineSeparator()));
    paragraph.add(String.valueOf(tocModel.getPageNo()));
    colTxt.addElement(paragraph);
    if (ColumnText.hasMoreText(colTxt.go()))
    {
        stamp.alterContents();
        copy.addPage(page);
        tocReader = new PdfReader("toc.pdf");
        page = copy.getImportedPage(tocReader, 1);
        tocPageCount++;
        stamp = copy.createPageStamp(page);
        y = 770;
        colTxt = new ColumnText(stamp.getOverContent());
        colTxt.setSimpleColumn(36, 36, 559, y);
        colTxt.go();
    }
    // seting toc action
    action = PdfAction.gotoLocalPage("p" + tocModel.getPageNo(), false);
    link = new PdfAnnotation(copy, 36, colTxt.getYLine(), 559, y,action);
    stamp.addAnnotation(link);
    y = colTxt.getYLine();
}

stamp.alterContents();
copy.addPage(page);

document.close();
logger.info("Finished TOC !!!");