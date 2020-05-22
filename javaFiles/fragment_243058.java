import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader2 {
    private Map<String, String> dataSet = new HashMap<String, String>();
    private XSSFWorkbook ExcelWBook;
    private XSSFSheet ExcelWSheet;
    private FormulaEvaluator Evaluator;
    private XSSFCell Cell;
    private XSSFRow Row;
    private int rowCount;
    private int columnCount;

    public DataReader2(String FileName, int rowNum) {
        loadDataFile(FileName);
        dataSet = getDataSet(rowNum);
    }

    public DataReader2(String FileName) {
        loadDataFile(FileName);
    }

    public static DataReader2 getReader(String FileName, int rowNum) {
        DataReader2 dataReader = new DataReader2(FileName, rowNum);
        return dataReader;
    }

    private void loadDataFile(String FileName) {
        try {
            String FilePath = "./data/" + FileName;
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            Evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
            ExcelWSheet = ExcelWBook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        rowCount = ExcelWSheet.getLastRowNum();
        return rowCount;
    }

    private Map<String, String> getDataSet(int rowNum) {
        DataFormatter formatter = new DataFormatter();
        Row = ExcelWSheet.getRow(rowNum);
        columnCount = Row.getLastCellNum();
        for (int i = 0; i < columnCount; i++) {
            Cell = ExcelWSheet.getRow(0).getCell(i);
            String key = formatter.formatCellValue(Cell, Evaluator);
            Cell = Row.getCell(i);
            String value = formatter.formatCellValue(Cell, Evaluator);
            dataSet.put(key, value);
        }
        return dataSet;
    }

    public String getValue(String key) {
        try {
            key = key.trim();
            String value = dataSet.get(key).trim();
            if (!value.isEmpty() && !value.equals(null)) {
                return value;
            } else {
                throw (new Exception("No key with name : " + key + " available in datasheet."));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}