import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.*;

import java.io.*;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

class PivotTableTest6 {

 public static void main(String[] args) throws IOException{
    Workbook wb = new XSSFWorkbook();
    String[][] data = new String[][]{{"STATUS","PASSED","VALUE"},{"BLUE","Y","20"},{"RED","N","10"},{"BLUE","N","30"}};

    XSSFSheet sheet = (XSSFSheet) wb.createSheet("data");
    XSSFSheet pivot = (XSSFSheet) wb.createSheet("summary");
    for(String[] dataRow : data){
        XSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows());
        for(String dataCell : dataRow){
            XSSFCell cell = row.createCell(row.getPhysicalNumberOfCells());
            cell.setCellValue(dataCell);
        }
    }

    XSSFTable table = sheet.createTable();    
    CTTable cttable = table.getCTTable();
    table.setDisplayName("table");
    cttable.setRef("A1:C4");
    cttable.setId(1);

    CTTableColumns columns = cttable.addNewTableColumns();
    columns.setCount(3);

    int i = 1;
    for (String colName : data[0]){
        CTTableColumn column = columns.addNewTableColumn();
        column.setId(++i);
        column.setName(colName);      
    }

    XSSFPivotTable pivotTable =  pivot.createPivotTable(new AreaReference("A1:C4", SpreadsheetVersion.EXCEL2007), new CellReference("A4"), sheet);

    pivotTable.addRowLabel(0);
    CTPivotField fld = pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldList().get(0);
    fld.setOutline(false);

    /*   
    Apache poi adds 4 pivot field items of type "default" (<item t="default"/>) here. 
    This is because there are 4 rows (A1:C4) and, because they don't have a look at the data, 
    they are assuming max 4 different values. This is fine because Excel will rebuild its pivot cache while opening. 

    But if we want changing defaults, then this is not fine. Then we must know what items there are.

    So we need at least as much items, as are different ones in the data, as numbered items: <item x="0"/><item x="1"/> 

    And we must build a cache definition which has shared elements for those items.
    */

    for (i = 0; i < 2; i++) {
     //take the first 2 items as numbered items: <item x="0"/><item x="1"/>
     fld.getItems().getItemArray(i).unsetT();
     fld.getItems().getItemArray(i).setX((long)i);
    }
    for (i = 3; i > 1; i--) {
     //remove further items
     fld.getItems().removeItem(i);
    }
    //set new items count
    fld.getItems().setCount(2);

    //build a cache definition which has shared elements for those items 
    //<sharedItems><s v="Y"/><s v="N"/></sharedItems>
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldList().get(0).getSharedItems().addNewS().setV("Y");
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldList().get(0).getSharedItems().addNewS().setV("N");

    fld.setDefaultSubtotal(false);

    pivotTable.addRowLabel(1);
    fld = pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldList().get(1);
    fld.setOutline(false);

    pivotTable.addColumnLabel(DataConsolidateFunction.COUNT, 2, "test");

    FileOutputStream fileOut = new FileOutputStream("pivotsample6.xlsx");
    wb.write(fileOut);
    wb.close();

 }
}