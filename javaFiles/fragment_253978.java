HSSFRow row  =null;

        for(int i=0;i<tableViewForExcel.getItems().size();i++){
             row= spreadsheet.createRow(i);          
             for(int j=0; j< tableViewForExcel.getColumns().size();j++) {                
                 if(tableViewForExcel.getColumns().get(j).getCellData(i) != null) {
                     row.createCell(j).setCellValue(tableViewForExcel.getColumns().get(j).getCellData(i).toString());
                 }else{
                     row.createCell(j).setCellValue("");
                 }
             }
         }