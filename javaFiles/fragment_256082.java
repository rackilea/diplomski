int beginingRow = sheet.getLastRowNum();
            for( int col=0; col<2; col++){
                int currentRow = beginingRow;
                for (int i=0; i<10; i++) {
                    currentRow++;
                    row = sheet.getRow(currentRow);
                    if(null == row)
                        row=sheet.createRow(currentRow);
                    c = row.createCell(col);
                    c.setCellValue("fff");
                    System.out.println("fff");
                    //System.out.println(entry.getKey() + "/" + entry.getValue());
                    rowNum++;
                }
            }