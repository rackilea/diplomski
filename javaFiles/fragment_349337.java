import java.io.File;
import java.io.IOException;
import com.healthmarketscience.jackcess.*;

public class jackcessTest {

    public static void main(String[] args) {
        try {
            Table table = DatabaseBuilder.open(new File("C:\\Users\\Public\\Database1.accdb")).getTable("Inventory");
            int numRows = table.getRowCount();
            String[] strArray = new String[numRows];
            int index = 0;
            for (Row row : table) {
                strArray[index++] = row.get("SerialNumber").toString();
            }
            System.out.println("The first item in the array is: " + strArray[0]);
            System.out.println("The last item in the array is: " + strArray[numRows - 1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}