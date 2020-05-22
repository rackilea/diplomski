import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

public class ReadWordHavingStyles {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("test.docx"));

  XWPFStyles styles = document.getStyles();
  XWPFStyle style = null;
  boolean isPBold = false;
  boolean isRBold = false;
  String boldReasonP = "";
  String boldReasonR = "";
  CTRPr cTRPr = null;

  for(XWPFParagraph paragraph : document.getParagraphs()) {
   isPBold = false;
   boldReasonP = "";
   String pStyleId = paragraph.getStyleID();
   if (pStyleId != null) {
    style = styles.getStyle(pStyleId);
    if (style != null) {
     String linkStyleId = style.getLinkStyleID();
     style = styles.getStyle(linkStyleId);
     if (style != null) {
      cTRPr = style.getCTStyle().getRPr();
      if (cTRPr != null) {
       if (!cTRPr.isSetB()) {
        isPBold = false;
       } else {
        STOnOff.Enum val = cTRPr.getB().getVal();
        isPBold = !((STOnOff.FALSE == val) || (STOnOff.X_0 == val) || (STOnOff.OFF == val));
       }
      }
      boldReasonP = " whole P is " + ((isPBold)?"":"not ") + "bold because of style " + linkStyleId;
     }
    }
   }

   if (!isPBold) boldReasonP = " P is not bold";

   for(XWPFRun run : paragraph.getRuns()){
    isRBold = isPBold;
    boldReasonR = "";
    cTRPr = run.getCTR().getRPr();
    if (cTRPr != null) {
     CTString rStyle = cTRPr.getRStyle();
     if (rStyle != null) {
      String rStyleId = rStyle.getVal();
      style = styles.getStyle(rStyleId);
      if (style != null) {
       cTRPr = style.getCTStyle().getRPr();
       if (cTRPr != null) {
        if (!cTRPr.isSetB()) {
         isRBold = false;
        } else {
         STOnOff.Enum val = cTRPr.getB().getVal();
         isRBold = !((STOnOff.FALSE == val) || (STOnOff.X_0 == val) || (STOnOff.OFF == val));
        }      
       }
       boldReasonR = " run is " + ((isRBold)?"":"not ") + "bold because of style " + rStyleId;
      }
     }
    }

    if (!isRBold) boldReasonR = " run is not bold";

    cTRPr = run.getCTR().getRPr();
    if (cTRPr != null) {
     if (cTRPr.isSetB()) {
      STOnOff.Enum val = cTRPr.getB().getVal();
      isRBold = !((STOnOff.FALSE == val) || (STOnOff.X_0 == val) || (STOnOff.OFF == val));
      boldReasonR = " run is " + ((isRBold)?"":"not ") + "bold because of direct formatting";
     }      
    }

    System.out.println(run.text() + " isBold:" + isRBold + ":" + boldReasonP + boldReasonR);

   }
  }

  document.close();
 }
}