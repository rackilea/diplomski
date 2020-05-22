import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.xmlbeans.XmlException;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.math.BigInteger;

public class CreateWordNumberedHeadings_Bill {

  static String cTStyleTOC1 ="<w:style xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:type=\"paragraph\" w:styleId=\"TOC1\">"
                + "<w:name w:val=\"toc 1\"/>"
                + "<w:basedOn w:val=\"Normal\"/>"
                + "<w:next w:val=\"Normal\"/>"
                + "<w:autoRedefine/><w:unhideWhenUsed/>"
                + "<w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" /><w:b/><w:bCs/><w:caps/><w:sz w:val=\"20\"/><w:szCs w:val=\"20\"/></w:rPr>"
                + "</w:style>";

  static String cTStyleTOC2 ="<w:style xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:type=\"paragraph\" w:styleId=\"TOC2\">"
                + "<w:name w:val=\"toc 2\"/>"
                + "<w:basedOn w:val=\"Normal\"/>"
                + "<w:next w:val=\"Normal\"/>"
                + "<w:autoRedefine/><w:unhideWhenUsed/>"
                + "<w:rPr><w:rFonts w:ascii=\"仿宋_GB2312\" w:cs=\"仿宋_GB2312\" /><w:sz w:val=\"20\"/><w:szCs w:val=\"20\"/></w:rPr>"
                + "</w:style>";

  public static void main(String[] args) throws Exception {

    XWPFDocument document = new XWPFDocument();
    createTOC(document);
    createtFirstTitle(document, "First Title");
    createtSecondTitle(document, "Second Title");
    createtSecondTitle(document, "Second Title");
    createtContent(document, "content ....");
    createtFirstTitle(document, "First Title");
    createtSecondTitle(document, "Second Title");
    createtSecondTitle(document, "Second Title");
    createtContent(document, "content ....");

    FileOutputStream out = new FileOutputStream("CreateWordNumberedHeadings_Bill.docx");
    document.write(out);
  }

  private static void createTOC( XWPFDocument document) throws XmlException {
    XWPFParagraph p = document.createParagraph();
    p.setSpacingBetween(1.25);
    p.setSpacingBeforeLines(150);
    p.setSpacingAfterLines(150);
    p.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun r = p.createRun();
    r.setText("目  录");
    r.setFontFamily("黑体");
    r.setFontSize(15);
    XWPFParagraph paragraph = document.createParagraph();
    CTSimpleField toc = paragraph.getCTP().addNewFldSimple();
    toc.setInstr("TOC \\* MERGEFORMAT");
    toc.setDirty(STOnOff.TRUE);
    XWPFStyles styles = document.createStyles();
    addCustomHeadingStyle(styles,"index1", 0, "黑体", 15f, false);
    addCustomHeadingStyle(styles,"index2", 1, "仿宋_GB2312", 14f, true);
    CTStyles cTStyles = CTStyles.Factory.parse(cTStyleTOC1);
    CTStyle cTStyle = cTStyles.getStyleArray(0);
    styles.addStyle(new XWPFStyle(cTStyle));
    cTStyles = CTStyles.Factory.parse(cTStyleTOC2);
    cTStyle = cTStyles.getStyleArray(0);
    styles.addStyle(new XWPFStyle(cTStyle));
  }

  private static void addCustomHeadingStyle(XWPFStyles styles, String strStyleId, int headingLevel, String fontFamily, float fontSize, boolean bold) {
    CTStyle ctStyle = CTStyle.Factory.newInstance();
    ctStyle.setStyleId(strStyleId);
    CTString styleName = CTString.Factory.newInstance();
    styleName.setVal(strStyleId);
    ctStyle.setName(styleName);
    CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
    indentNumber.setVal(BigInteger.valueOf(headingLevel));
    // lower number > style is more prominent in the formats bar
    ctStyle.setUiPriority(indentNumber);
    CTOnOff onoffnull = CTOnOff.Factory.newInstance();
    ctStyle.setUnhideWhenUsed(onoffnull);
    // style shows up in the formats bar
    ctStyle.setQFormat(onoffnull);
    // style defines a heading of the given level
    CTPPr ppr = CTPPr.Factory.newInstance();
    ppr.setOutlineLvl(indentNumber);
    ctStyle.setPPr(ppr);

    CTRPr rPr = ctStyle.addNewRPr();
    rPr.addNewRFonts().setAscii(fontFamily);
    rPr.getRFonts().setCs(fontFamily);
    rPr.addNewSz().setVal(BigInteger.valueOf((long)(fontSize*2)));
    rPr.addNewSzCs().setVal(BigInteger.valueOf((long)(fontSize*2)));
    if (bold) {
     rPr.addNewB();
     rPr.addNewBCs();
    }

    XWPFStyle style = new XWPFStyle(ctStyle);
    style.setType(STStyleType.PARAGRAPH);
    styles.addStyle(style);
  }

  public static void createtFirstTitle(XWPFDocument doc,String title){
    XWPFParagraph para = doc.createParagraph();
    para.setSpacingBetween(1.25);
    para.setSpacingBeforeLines(150);
    para.setSpacingAfterLines(150);
    para.setAlignment(ParagraphAlignment.CENTER);
    para.setStyle("index1");
    para.setPageBreak(true);
    XWPFRun r = para.createRun();
    r.setText(title);
    //r.setFontSize(15);
    //r.setFontFamily("黑体");
  }

  public static void createtSecondTitle(XWPFDocument doc,String title){
    XWPFParagraph para = doc.createParagraph();
    para.setStyle("index2");
    para.setFirstLineIndent(600);
    para.setAlignment(ParagraphAlignment.LEFT);
    para.setSpacingBetween(1.25);
    para.setSpacingBefore(270);
    para.setSpacingAfter(270);
    XWPFRun r = para.createRun();
    r.setText(title);
    //r.setFontSize(14);
    //r.setBold(true);
    //r.setFontFamily("仿宋_GB2312");
  }

  public static void createtContent(XWPFDocument doc, String content){
    XWPFParagraph para = doc.createParagraph();
    para.setAlignment(ParagraphAlignment.LEFT);
    para.setFirstLineIndent(600);
    para.setSpacingBetween(1.25);
    XWPFRun run = para.createRun();
    run.setText(content);
    run.setFontFamily("仿宋_GB2312");
    run.setFontSize(14);
  }
}