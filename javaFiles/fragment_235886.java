import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import java.awt.Color;

public class CreatePPTXSheetsDifferentBackground {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow();
  XSLFSlide slide = slideShow.createSlide();
  if (slide.getXmlObject().getCSld().getBg() == null) slide.getXmlObject().getCSld().addNewBg();
  slide.getBackground().setFillColor(Color.BLUE);
  slide = slideShow.createSlide();
  if (slide.getXmlObject().getCSld().getBg() == null) slide.getXmlObject().getCSld().addNewBg();
  slide.getBackground().setFillColor(Color.RED);

  FileOutputStream out = new FileOutputStream("CreatePPTXSheetsDifferentBackground.pptx");
  slideShow.write(out);
  out.close();
 }
}