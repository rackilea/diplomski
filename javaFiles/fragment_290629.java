import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javax.swing.JButton;
        import org.apache.poi.EncryptedDocumentException;
        import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
        import org.apache.poi.openxml4j.util.ZipSecureFile;
        import org.apache.poi.sl.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.ss.usermodel.WorkbookFactory;
        import org.apache.poi.xssf.usermodel.XSSFCell;
        import org.apache.poi.xssf.usermodel.XSSFRow;
        import org.apache.poi.xssf.usermodel.XSSFSheet;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

        public class try1 {
           public static void main(String[] args)
        throws FileNotFoundException, IOException {
             File[] files=new File("D:\\aa\\a").listFiles();
                   String s = null;
                                   for(File file:files){
                                    s=file.getName();
                                            s=s.replaceAll(".xlsx", "");  

                    File xl=new File("D:\\aa\\w1.xlsx");
                    FileInputStream f=new FileInputStream(xl);

                   XSSFWorkbook wb = new XSSFWorkbook (f);
                    XSSFSheet sheet = wb.getSheetAt(0);
                    int row=sheet.getLastRowNum();
                int colm=sheet.getRow(0).getLastCellNum();
                for(int i=0;i<row;i++){

                    XSSFRow r = sheet.getRow(i);
                    if(r==null){
                       sheet.getRow(i+1);
                        continue;
                    }
                Cell cell=r.getCell(0);
                String m=cellToString(r.getCell(0));
                if(s.equals(m)){
                  System.out.println("s :"+m);
                   sheet.removeRow(r);

                   }}


                FileOutputStream out= 
            new FileOutputStream(new File("D:\\aa\\w1.xlsx"));
               wb.write(out);
                }               
                     }public static String cellToString(XSSFCell cell) {

                int type;
                Object result = null;
                type = cell.getCellType();
               switch (type) {
                 case XSSFCell.CELL_TYPE_STRING:
                    result = cell.getStringCellValue();
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    result = "";
                    break;
                case XSSFCell.CELL_TYPE_FORMULA:
                    result = cell.getCellFormula();
                }

                return result.toString();
            }

        }