import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import java.awt.Rectangle;
import java.awt.Color;

public class CreatePPTXGroupShape {

 public static void main(String[] args) throws Exception {

  SlideShow slideShow = new XMLSlideShow();

  Slide slide = slideShow.createSlide();

  int groupLeft = 100;
  int groupTop = 50;
  int groupWidth = 350;
  int groupHeight = 300;
  int groupPadding= 10;

  GroupShape group = slide.createGroup();
  group.setInteriorAnchor(new Rectangle(groupLeft, groupTop, groupWidth, groupHeight));
  group.setAnchor(new Rectangle(groupLeft+groupPadding, groupTop+groupPadding, groupWidth-groupPadding, groupHeight-groupPadding));

  AutoShape shape = group.createAutoShape();
  shape.setShapeType(ShapeType.RECT);
  shape.setFillColor(Color.GREEN);
  shape.setAnchor(new Rectangle(groupLeft, groupTop, 150, 100));

  shape = group.createAutoShape();
  shape.setShapeType(ShapeType.TRIANGLE);
  shape.setFillColor(Color.RED);
  shape.setAnchor(new Rectangle(groupLeft+groupWidth-120, groupTop, 120, 100));

  shape = group.createAutoShape();
  shape.setShapeType(ShapeType.DONUT);
  shape.setFillColor(Color.YELLOW);
  shape.setAnchor(new Rectangle(groupLeft, groupTop+groupHeight-90, 90, 90));

  shape = group.createAutoShape();
  shape.setShapeType(ShapeType.ELLIPSE);
  shape.setFillColor(Color.BLUE);
  shape.setAnchor(new Rectangle(groupLeft+groupWidth-100, groupTop+groupHeight-100, 100, 100));

  FileOutputStream out = new FileOutputStream("CreatePPTXGroupShape.pptx");
  slideShow.write(out);
  out.close();
 }
}