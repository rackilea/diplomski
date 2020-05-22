import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute.Space;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;

public class CrossReference {

    public static void main(String[] args) throws InvalidFormatException, IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();

        document.createParagraph().createRun().addBreak(BreakType.PAGE);

        XWPFParagraph pictureParagraph = document.createParagraph();
        pictureParagraph.setSpacingAfter(0);

        XWPFRun pictureRun = pictureParagraph.createRun();
        String imgPath = "img.png";
        pictureRun.addPicture(new FileInputStream(imgPath), 
                XWPFDocument.PICTURE_TYPE_PNG, 
                imgPath, 
                Units.toEMU(288), 
                Units.toEMU(288));

        XWPFParagraph captionParagraph = document.createParagraph();
        XWPFRun captionRun = captionParagraph.createRun();
        CTText ctText = captionRun.getCTR().addNewInstrText();
        ctText.setSpace(Space.PRESERVE);
        ctText.setStringValue("Figure ");
        CTBookmark bookmark = captionParagraph.getCTP().addNewBookmarkStart();
        bookmark.setName("Figure-1");
        bookmark.setId(BigInteger.valueOf(0));

        CTSimpleField ctSimpleField = captionParagraph.getCTP().addNewFldSimple();
        ctSimpleField.setInstr("SEQ Figure \\* ARABIC");
        CTR ctR = ctSimpleField.addNewR();
        ctR.addNewRPr().setNoProof(CTOnOff.Factory.newInstance());
        ctR.addNewT().setStringValue(Integer.toString(1));

        captionParagraph.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(0));
        captionParagraph.setSpacingAfter(0);

        paragraph.createRun().getCTR().addNewFldChar().setFldCharType(STFldCharType.BEGIN);

        ctText = paragraph.createRun().getCTR().addNewInstrText();
        ctText.setSpace(Space.PRESERVE);
        ctText.setStringValue("REF Figure-1 \\h");

        paragraph.createRun().getCTR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);

        ctText = paragraph.createRun().getCTR().addNewT();
        ctText.setSpace(Space.PRESERVE);
        ctText.setStringValue("Figure ");

        ctR = paragraph.createRun().getCTR();
        ctR.addNewRPr().setNoProof(CTOnOff.Factory.newInstance());
        ctR.addNewT().setStringValue(Integer.toString(1));

        paragraph.createRun().getCTR().addNewFldChar().setFldCharType(STFldCharType.END);

        FileOutputStream out = new FileOutputStream(new File("test.docx"));
        document.write(out);
        out.close();
        document.close();
    }

}