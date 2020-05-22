public static XWPFRun createRun(XWPFParagraph paragraph, String     fontFamily, int fontSize, boolean bold, UnderlinePatterns underline){
    XWPFRun run = paragraph.createRun();
    run.setFontFamily(fontFamily);
    run.setBold(bold);
    run.setUnderline(underline);
    run.setFontSize(fontSize);
    return run;
}