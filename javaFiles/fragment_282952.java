import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import java.awt.Rectangle;

public class CreatePPTXTextBoxBullet {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow();

  XSLFSlide slide = slideShow.createSlide();

  XSLFTextBox textbox = slide.createTextBox(); 
  textbox.setAnchor(new Rectangle(50, 100, 570, 100));
  XSLFTextParagraph paragraph = textbox.addNewTextParagraph(); 
  paragraph.setBullet(true);
  paragraph.setLeftMargin(25.2); //left margin = indent for the text; 25.2 pt = 25.2/72 = 0.35"
  paragraph.setIndent(-25.2);  //hanging indent first row for the bullet point; -25.2 pt, so first row indent is 0.00 in sum
  paragraph.setFontAlign(TextParagraph.FontAlign.TOP);
  paragraph.setTextAlign(TextParagraph.TextAlign.LEFT);
  XSLFTextRun run = paragraph.addNewTextRun();
  run.setText("Text analysis, nGram, Naïve Bayes Text Classifier to identify the nature of the conversation, sentiment and risk of complaint being made");

  FileOutputStream out = new FileOutputStream("CreatePPTXTextBoxBullet.pptx");
  slideShow.write(out);
  out.close();
 }
}