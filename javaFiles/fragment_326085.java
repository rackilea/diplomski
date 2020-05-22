import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesclassSample {

    @Test(dataProvider = "dp")
    public void testMethod(String name, int age, String run) {
        System.err.println("Name :" + name + ", Age :" + age + ", Run value " + run);
    }

    @DataProvider(name = "dp")
    public Object[][] readnumericvalue() throws IOException {
        File src = new File("src/test/resources/47032451.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);

        int columnCount = sheet1.getRow(0).getLastCellNum();
        List<List<Object>> objects = new ArrayList<>();

        Iterator<Row> rowIterator = sheet1.iterator();
        boolean firstRow = true;
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            if (firstRow) {
                firstRow = false;
                continue;
            }
            Iterator<Cell> cellIterator = currentRow.iterator();
            List<Object> iterationRow = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        iterationRow.add(cell.getStringCellValue());
                        break;

                    case Cell.CELL_TYPE_NUMERIC:
                        iterationRow.add(new Double(cell.getNumericCellValue()).intValue());
                        break;
                }
            }
            //Consider the iteration for adding only if the "Run" column had a "Y"
            if ("y".equalsIgnoreCase(iterationRow.get(2).toString().trim())) {
                objects.add(iterationRow);
            }
        }
        //Now that we have the arraylist, lets translate it back to a 2D array.
        Object toReturn[][] = new Object[objects.size()][columnCount];
        for (int i = 0; i < objects.size(); i++) {
            toReturn[i] = objects.get(i).toArray();
        }
        return toReturn;
    }
}