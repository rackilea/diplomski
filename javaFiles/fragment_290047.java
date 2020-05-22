public static XWPFRun createRun(XWPFParagraph paragraph){
    XWPFRun run = paragraph.createRun();
    run.setFontSize(12);
    run.setFontFamily("Times New Roman");
    return run;
}