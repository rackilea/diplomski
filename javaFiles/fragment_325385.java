import java.awt.Rectangle;
import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

public class TextBoxOverflow {
    public static void main(String[] args) throws Exception {

        XMLSlideShow slideShow = new XMLSlideShow();

        XSLFSlide slide = slideShow.createSlide();

        XSLFTextBox textBox = slide.createTextBox();
        XSLFTextParagraph paragraph = textBox.getTextParagraphs().get(0);
        XSLFTextRun textRun = paragraph.addNewTextRun();

        textRun.setText(
            "ちょっと早いけどTシャツが着たくなる季節♡お母さんの影響か、非常に恐竜が大好きです。もう飼いたいくらい大好きです。#ジュラシックワールド のラプトル4姉妹とか激的に可愛くて可愛くて可愛くて可愛いです。めろめろ、大好き♡お母さんも恐竜が好きで、小さい頃、古代生物の図鑑を一緒に見てたの思い出す〜とい");

        textBox.setAnchor(new Rectangle(50, 50, 200, 5000));

        double heigth = textBox.getTextHeight();
System.out.println(heigth);

        textBox.resizeToFitText();

        CTShape ctshape = (CTShape)textBox.getXmlObject();
System.out.println(ctshape.getSpPr());

        //set TextBox autofit the text 
        ctshape.getTxBody().getBodyPr().addNewSpAutoFit();

        FileOutputStream out = new FileOutputStream("TextBoxOverflow.pptx");
        slideShow.write(out);
        out.close();
        slideShow.close();
    }
}