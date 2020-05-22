PdfReader reader = new PdfReader(SRC3);
page = copy.getImportedPage(reader, 1);
stamp = copy.createPageStamp(page);
Paragraph p;
PdfAction action;
PdfAnnotation link;
float y = 770;
ColumnText ct = new ColumnText(stamp.getOverContent());
ct.setSimpleColumn(36, 36, 559, y);
for (Map.Entry<Integer, String> entry : toc.entrySet()) {
    p = new Paragraph(entry.getValue());
    p.add(new Chunk(new DottedLineSeparator()));
    p.add(String.valueOf(entry.getKey()));
    ct.addElement(p);
    ct.go();
    action = PdfAction.gotoLocalPage("p" + entry.getKey(), false);
    link = new PdfAnnotation(copy, 36, ct.getYLine(), 559, y, action);
    stamp.addAnnotation(link);
    y = ct.getYLine();
}
ct.go();
stamp.alterContents();
copy.addPage(page);