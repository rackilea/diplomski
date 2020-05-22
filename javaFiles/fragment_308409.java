import java.io.*;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;

import java.util.List;
import java.util.ArrayList;

import java.net.URL;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Dimension;

public class CreateWordPicturesInTextRuns {

 public static void main(String[] args) throws Exception {

  List<String> pictureURLs = new ArrayList<String>();
  pictureURLs.add("https://www.eastcottvets.co.uk/uploads/Animals/gingerkitten.jpg");
  pictureURLs.add("https://www.catster.com/wp-content/uploads/2017/12/A-kitten-meowing.jpg");
  pictureURLs.add("https://www.animalfriends.co.uk/app/uploads/2014/08/06110347/Kitten-small.jpg");
  pictureURLs.add("https://d27ucmmhxk51xv.cloudfront.net/media/english/illustration/kitten.jpg");

  XWPFDocument document= new XWPFDocument();
  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();
  run.setText("The kitten pictures: ");

  URL url;
  BufferedImage image;
  Dimension dim;
  ByteArrayOutputStream bout;
  ByteArrayInputStream bin;
  for (String pictureURL : pictureURLs) {

   url = new URL(pictureURL);
   image = ImageIO.read(url);
   dim = new Dimension(image.getWidth(), image.getHeight());
   double width = dim.getWidth();
   double height = dim.getHeight();
   double scaling = 1.0;
   if (width > 72*3) scaling = (72*3)/width; //scale width not to be greater than 3 inches

   bout = new ByteArrayOutputStream();
   ImageIO.write(image, "jpeg", bout);
   bout.flush();
   bin = new ByteArrayInputStream(bout.toByteArray());
   run = paragraph.createRun();
   run.addPicture(bin, XWPFDocument.PICTURE_TYPE_JPEG, "kitten", 
    Units.toEMU(width*scaling), Units.toEMU(height*scaling));

   //lock aspect ratio
   run.getCTR().getDrawingArray(0).getInlineArray(0).addNewCNvGraphicFramePr().addNewGraphicFrameLocks().setNoChangeAspect(true);

  }

  FileOutputStream out = new FileOutputStream("CreateWordPicturesInTextRuns.docx");
  document.write(out);
  out.close();
  document.close();

 }
}