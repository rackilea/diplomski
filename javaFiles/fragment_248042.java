HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("sheet");
    //Create a new row in current sheet
    Row row = sheet.createRow(0);
    //Create a new cell in current row
    for(String key:map.keySet())
    {
        Cell cell1=row.createCell(columnNum);
        cell1.setCellValue(key);
        //System.out.println(map.get(key));
        List<Integer> columnValues = map.get(key);
        int tempHeight=columnValues.size();
        /*if(maxRows<tempHeight)
        {
            maxRows=tempHeight;
        }*/
        int temp=1;
        for(int i:columnValues)
        {
            Row row2;
            //System.out.println("no of rows:"+(sheet.getPhysicalNumberOfRows()-1)+", height:"+tempHeight);
            if(sheet.getPhysicalNumberOfRows()-1>temp-1)
            {
                //System.out.println("take row");
                row2=sheet.getRow(temp);

            }
            else
            {

                //System.out.println("Row inserted");
                row2=sheet.createRow(temp);
            }
            Cell cell2=row2.createCell(columnNum);
            cell2.setCellValue(i);
            temp=temp+1;
        }

        columnNum=columnNum+1;


    }