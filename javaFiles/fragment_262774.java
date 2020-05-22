Color fontColor = null;
String fontFamily = null;
double fontSize = 0.0;
boolean italic = false;
boolean bold = false;
boolean underline = false;
for (XSLFTextParagraph paragraph : autoShape.getTextParagraphs()) {
    for (XSLFTextRun text : paragraph.getTextRuns()) {
        fontColor = text.getFontColor();
        fontFamily = text.getFontFamily();
        fontSize = text.getFontSize();
        italic = text.isItalic();
        bold = text.isBold();
        underline = text.isUnderline();
    }
}
autoShape.clearText();
XSLFTextParagraph addNewTextParagraph = autoShape.addNewTextParagraph();

XSLFTextRun addNewTextRun = addNewTextParagraph.addNewTextRun();
addNewTextRun.setText(values.get(0)[1]);
addNewTextRun.setFontColor(fontColor);
addNewTextRun.setFontFamily(fontFamily);
addNewTextRun.setFontSize(fontSize);
addNewTextRun.setItalic(italic);
addNewTextRun.setBold(bold);
addNewTextRun.setUnderline(underline);