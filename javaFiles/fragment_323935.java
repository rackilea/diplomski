import java.io.*;

import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;

import java.util.Calendar;
import java.text.SimpleDateFormat;

  public class ApacheCreatePivotTable
    {
        public static void main(String[] args) throws Exception
        {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = (XSSFSheet) wb.createSheet();

            //Create some data to build the pivot table on
            setCellData(sheet);

            //System.out.println(sheet.getRow(0).getLastCellNum());

            XSSFPivotTable pivotTable = sheet.createPivotTable(new AreaReference(new CellReference(0,0),new CellReference(4,sheet.getRow(0).getLastCellNum()-1)), new CellReference(0,7));

            pivotTable.addRowLabel(0);

    //set tabular layout instead of tree layout
    pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).setOutline(false);

    /*   
    Apache poi adds 5 pivot field items of type "default" (<item t="default"/>) here. 
    This is because there are 5 rows (A1:C5) and, because they don't have a look at the data, 
    they are assuming max 5 different values. This is fine because Excel will rebuild its pivot cache while opening. 

    But if we want changing defaults, then this is not fine. Then we must know what items there are.

    So we need at least as much items, as where different ones in the data, as numbered items: <item x="0"/><item x="1"/> 

    And we must build a cache definition which has shared elements for those items.
    */


    for (int i = 0; i < 3; i++) {
     //take the first 3 items as numbered items: <item x="0"/><item x="1"/>
     pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().getItemArray(i).unsetT();
     pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().getItemArray(i).setX((long)i);
    }

    for (int i = 4; i > 2; i--) {
     //remove further items
     pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().removeItem(i);
    }

    //set new items count
    pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().setCount(3);

    //build a cache definition which has shared elements for those items 
    //<sharedItems><s v="tom"/><s v="Ram"/><s v="Terk"/></sharedItems>
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldList().get(0).getSharedItems().addNewS().setV("tom");
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldList().get(0).getSharedItems().addNewS().setV("Ram");
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldList().get(0).getSharedItems().addNewS().setV("Terk");

    pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).setDefaultSubtotal(false);

            pivotTable.addRowLabel(1);




            pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 3);

            pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2).setAxis(
                    org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis.AXIS_COL);


            pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2).addNewItems();
            pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2).getItems().addNewItem().setT(
                    org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType.DEFAULT);

            pivotTable.getCTPivotTableDefinition().addNewColFields().addNewField().setX(2);

            FileOutputStream fileOut = new FileOutputStream("output.xlsx");
            wb.write(fileOut);
            fileOut.close();
            wb.close();
        }

        public static void setCellData(XSSFSheet sheet)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Row row1 = sheet.createRow(0);
            // Create a cell and put a value in it.
            Cell cell11 = row1.createCell(0);
            cell11.setCellValue("Names");
            Cell cell12 = row1.createCell(1);
            cell12.setCellValue("falility");
            Cell cell13 = row1.createCell(2);
            cell13.setCellValue("date");
            Cell cell14 = row1.createCell(3);
            cell14.setCellValue("cost");

            Row row2 = sheet.createRow(1);
            Cell cell21 = row2.createCell(0);
            cell21.setCellValue("tom");
            Cell cell22 = row2.createCell(1);
            cell22.setCellValue("Nal stop");
            Cell cell23 = row2.createCell(2);
            Calendar cal = Calendar.getInstance();
            cal.set(2017,07,18);
            cell23.setCellValue(sdf.format(cal.getTime()));
            Cell cell24 = row2.createCell(3);
            cell24.setCellValue(10);

            Row row3 = sheet.createRow(2);
            Cell cell31 = row3.createCell(0);
            cell31.setCellValue("Ram");
            Cell cell32 = row3.createCell(1);
            cell32.setCellValue("Vadgao");
            Cell cell33 = row3.createCell(2);
            cal.set(2017,07,19);
            cell33.setCellValue(sdf.format(cal.getTime()));
            Cell cell34 = row3.createCell(3);
            cell34.setCellValue(12);

            Row row4 = sheet.createRow(3);
            Cell cell41 = row4.createCell(0);
            cell41.setCellValue("Terk");
            Cell cell42 = row4.createCell(1);
            cell42.setCellValue("Deccan");
            Cell cell43 = row4.createCell(2);
            cal.set(2017,07,20);
            cell43.setCellValue(sdf.format(cal.getTime()));
            Cell cell44 = row4.createCell(3);
            cell44.setCellValue(11);

            Row row5 = sheet.createRow(4);
            Cell cell51 = row5.createCell(0);
            cell51.setCellValue("tom");
            Cell cell52 = row5.createCell(1);
            cell52.setCellValue("baner");
            Cell cell53 = row5.createCell(2);
            cal.set(2017,07,18);
            cell53.setCellValue(sdf.format(cal.getTime()));
            Cell cell54 = row5.createCell(3);
            cell54.setCellValue(20);

        }
    }