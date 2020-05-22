Map<Integer, Integer> map = new HashMap<Integer, Integer>();
     for(int i=1;i<numRows;i++){
         HSSFCell proId = sheet.getRow(i).getCell(1);
         HSSFCell sales = sheet.getRow(i).getCell(2);
         int prodId =(int)proId.getNumericCellValue();
         int currentSales =(int)sales.getNumericCellValue();
         //the data from the excel sheet is copied into the 2D array at this point
        if (map.containsKey(i)) {
            int prevSales = map.get(i);
            map.put(i, prevSales+currentSales);
        } else {
            map.put(i, currentSales);
        }
    }