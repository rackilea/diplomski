import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.SpreadsheetVersion;

import java.io.FileInputStream;
import java.io.FileOutputStream;

class PivotTableCreating {

 public static void main(String[] args) throws Exception{

  XSSFWorkbook wb = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("PivotExample.xlsx"));

  XSSFSheet pivotSheet = wb.createSheet("pivot");

  XSSFSheet dataSheet = wb.getSheet("data");
  int lastRowNum = dataSheet.getLastRowNum();

  XSSFPivotTable pivotTable = pivotSheet.createPivotTable(
   new AreaReference(new CellReference("data!A1"), new CellReference("data!D" + (lastRowNum+1)), 
   SpreadsheetVersion.EXCEL2007),
   new CellReference("A5"));

  pivotTable.addRowLabel(1);

  pivotTable.addRowLabel(2); //column C as a row label = RowField and AXIS_ROW

  //do changing column C as a col label
  pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2)
   .setAxis(org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis.AXIS_COL); //AXIS_COL

  //remove column C from RowFields
  pivotTable.getCTPivotTableDefinition().getRowFields().removeField(1); 
  pivotTable.getCTPivotTableDefinition().getRowFields().setCount(1);

  //create ColFields for column C
  pivotTable.getCTPivotTableDefinition().addNewColFields().addNewField().setX(2); 
  pivotTable.getCTPivotTableDefinition().getColFields().setCount(1);

  pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 3);

  wb.write(new FileOutputStream("PivotExampleNew.xlsx"));
  wb.close();

 }
}