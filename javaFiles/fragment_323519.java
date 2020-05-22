import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.xssf.usermodel.*;

class CreateExcelPictures {

 static String excelPath = "./ExcelWithLogo.xlsx";
 static String appPath = "./";
 static XSSFWorkbook workbook;
 static XSSFSheet sheet;

 static void addImage(int col1, int row1, int col2, int row2, String imageFileName, ClientAnchor.AnchorType anchorType) throws Exception {

  InputStream imageInputStream = new FileInputStream(imageFileName);
  byte[] bytes = IOUtils.toByteArray(imageInputStream);
  int pictureId = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
  imageInputStream .close();

  XSSFClientAnchor anchor = workbook.getCreationHelper().createClientAnchor();
  anchor.setAnchorType(anchorType);
  anchor.setCol1(col1);
  anchor.setRow1(row1);
  anchor.setCol2(col2);
  anchor.setRow2(row2);

  XSSFDrawing drawing = sheet.createDrawingPatriarch();

  XSSFPicture picture = drawing.createPicture(anchor, pictureId);

 }

 public static void main(String args[]) throws Exception {

  workbook = new XSSFWorkbook();
  sheet = workbook.createSheet();

  addImage(1, 1, 3, 4, appPath + "sample_logo.png", ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE); 

  FileOutputStream fos = new FileOutputStream(excelPath);
  workbook.write(fos);
  fos.close();
  workbook.close();

 }
}