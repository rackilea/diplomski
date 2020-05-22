final PdfTemplate textTemplate1 = PdfTemplate.createTemplate(pdfWriter, textWidth, textHeight);
final PdfTemplate textTemplate2 = PdfTemplate.createTemplate(pdfWriter, textWidth, textHeight);

final ColumnText columnText = new ColumnText(textTemplate1);
columnText.setSimpleColumn(0f, 0f, textTemplate1.getWidth(), textTemplate1.getHeight());
columnText.addElement(paragraph);
columnText.go();

columnText.setCanvas(textTemplate2);
columnText.setSimpleColumn(0f, 0f, textTemplate2.getWidth(), textTemplate2.getHeight());
columnText.go();