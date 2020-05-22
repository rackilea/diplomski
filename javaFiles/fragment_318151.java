import java.awt.Desktop;
import java.io.*;
import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

public class POIExample {
    public static void main(String[] args) {
        try {
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();

            XWPFRun tmpRun = paragraph.createRun();
            tmpRun.setText("JAN");
            tmpRun.addTab();
            tmpRun.setText("JAN");
            tmpRun.addTab();
            tmpRun.setText("JAN");

            BigInteger pos1 = BigInteger.valueOf(4500);
            setTabStop(paragraph, STTabJc.Enum.forString("center"), pos1);
            BigInteger pos2 = BigInteger.valueOf(9000);
            setTabStop(paragraph, STTabJc.Enum.forString("right"), pos2);

            File f = File.createTempFile("poi", ".docx");
            try (FileOutputStream fo = new FileOutputStream(f)) {
                document.write(fo);
            }
            Desktop.getDesktop().open(f);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setTabStop(XWPFParagraph oParagraph, STTabJc.Enum oSTTabJc, BigInteger oPos) {
        CTP oCTP = oParagraph.getCTP();
        CTPPr oPPr = oCTP.getPPr();
        if (oPPr == null) {
            oPPr = oCTP.addNewPPr();
        }

        CTTabs oTabs = oPPr.getTabs();
        if (oTabs == null) {
            oTabs = oPPr.addNewTabs();
        }

        CTTabStop oTabStop = oTabs.addNewTab();
        oTabStop.setVal(oSTTabJc);
        oTabStop.setPos(oPos);
    }
}