import org.apache.poi.hssf.usermodel.HSSFSheet;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;


public class ReadFromExcel {

    public static void main(String[] args) throws FileNotFoundException {
        File f=new File("C:"+File.separator+"Personal"+File.separator+"test.xlsx");
        FileInputStream file=null;
        if(f.exists()) {
            file = new FileInputStream(f);
            //rest of code
        } else{
            System.out.println("The file does not exist!Please enter correct filename!");
        }
    }
}