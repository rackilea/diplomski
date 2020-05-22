import java.io.FileOutputStream;

import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;

class CreatePivotTablePercentAndFilter {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("ooxml-pivottable.xlsx") ) {

   Sheet pivotSheet = workbook.createSheet("Pivot");
   Sheet dataSheet = workbook.createSheet("Data");

   setCellData(dataSheet);

   AreaReference areaReference = new AreaReference("A1:D5", SpreadsheetVersion.EXCEL2007);

   XSSFPivotTable pivotTable = ((XSSFSheet)pivotSheet).createPivotTable(areaReference, new CellReference("A4"), dataSheet);

   pivotTable.addRowLabel(0);

   pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
   pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1,"% of value");

   pivotTable.getCTPivotTableDefinition().getDataFields().getDataFieldArray(1).setShowDataAs(
    org.openxmlformats.schemas.spreadsheetml.x2006.main.STShowDataAs.PERCENT_OF_COL);
   DataFormat dataformat = workbook.createDataFormat();
   short numFmtId = dataformat.getFormat("0.00%");
   pivotTable.getCTPivotTableDefinition().getDataFields().getDataFieldArray(1).setNumFmtId(numFmtId);

   /*   
   Apache poi adds 5 pivot field items of type "default" (<item t="default"/>) for each row label here. 
   This is because there are 5 rows (A1:D5) and, because they don't want have a look at the data, 
   they are assuming max 5 different values. 
   This is fine because Excel will rebuild its pivot cache while opening. 

   But if we want preselect items, then this is not fine. Then we must know what items there are that can be preselected.

   So we need at least as much items as we want preselect being numbered items: <item x="0"/><item x="1"/><item x="2"/>...
   And we must build a cache definition which has shared elements for those items.

   To fulfill that we need determine the unique labels in column. 
   Then for each unique label take the item as numbered item. 
   Then build a cache definition which has shared elements for those items. 
   Then set all not wanted items hidden.
   */

   //determine unique labels in column 0
   java.util.TreeSet<String> uniqueItems = new java.util.TreeSet<String>();
   for (int r = areaReference.getFirstCell().getRow()+1; r < areaReference.getLastCell().getRow()+1; r++) {
    uniqueItems.add(dataSheet.getRow(r).getCell(areaReference.getFirstCell().getCol()).getStringCellValue());
   }
   System.out.println(uniqueItems);
   int i = 0;
   for (String item : uniqueItems) {
    //take the items as numbered items: <item x="0"/><item x="1"/><item x="2"/>
    pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().getItemArray(i).unsetT();
    pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().getItemArray(i).setX((long)i);
    //build a cache definition which has shared elements for those items 
    //<sharedItems><s v="Jack"/><s v="Jane"/><s v="Tarzan"/><s v="Terk"/></sharedItems>
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldArray(0)
    .getSharedItems().addNewS().setV(item);
    i++;
   }

   //Now we can predefinite a filter.
   //If the need is selecting multiple items, first MultipleItemSelectionAllowed needs to be set.
   pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).setMultipleItemSelectionAllowed(true);
   //Then set H(idden) true for all items which not shall be selected. All except "Jane" in this case.
   i = 0;
   for (String item : uniqueItems) {
    if (!"Jane".equals(item))
     pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().getItemArray(i).setH(true);
    i++;
   }

   workbook.write(fileout);
  }
 }

 static void setCellData(Sheet sheet) {
  Row row;
  Cell cell;
  Object[][] data = new Object[][]{
   new Object[]{"Names", "Values", "ColC", "ColD"},
   new Object[]{"Jane", 10d, "?", "?"},
   new Object[]{"Tarzan", 5d, "?", "?"},
   new Object[]{"Terk", 10d, "?", "?"},
   new Object[]{"Jack", 10d, "?", "?"}
  };
  for (int r = 0; r < data.length; r++) {
   row = sheet.createRow(r);
   Object[] rowData = data[r];
   for (int c = 0; c < rowData.length; c++) {
    cell = row.createCell(c);
    if (rowData[c] instanceof String) {
     cell.setCellValue((String)rowData[c]);
    } else if (rowData[c] instanceof Double) {
     cell.setCellValue((Double)rowData[c]);
    }
   }
  }
 }
}